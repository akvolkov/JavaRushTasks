package com.javarush.task.task35.task3513;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Home PC Volkov on 31.03.2018.
 */
public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
    protected int score;
    protected int maxTile;
    public Stack<Tile[][]> previousStates = new Stack<>();
    public Stack<Integer> previousScores = new Stack<>();
    private boolean isSaveNeeded = true;

    public Model() {
        resetGameTiles();
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    private void addTile() {
        if (!getEmptyTiles().isEmpty()) {
            List<Tile> list = getEmptyTiles();
            int randomTile = (int) (list.size() * Math.random());
            int randomValueTile = Math.random() < 0.9 ? 2 : 4;
            list.get(randomTile).value = randomValueTile;
        }
    }

    private List<Tile> getEmptyTiles() {
        ArrayList<Tile> arr = new ArrayList<>();
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                if (gameTiles[i][j].isEmpty()) {
                    arr.add(gameTiles[i][j]);
                }
            }
        }
        return arr;
    }

    void resetGameTiles() {
        score = 0;
        maxTile = 2;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                gameTiles[i][j] = new Tile();
            }
        }
        addTile();
        addTile();
    }

    private boolean compressTiles(Tile[] tiles) {
        boolean isChanged=false;
        int number = 0;
        for (int i=0;i<tiles.length-1;i++){
            if (tiles[i].value==0&&tiles[i+1].value!=0){
                isChanged=true;
                int temp;
                temp=tiles[i].value;
                tiles[i].value=tiles[i+1].value;
                tiles[i+1].value=temp;
                i=-1;
            }
        }

        return isChanged;
    }
    private boolean mergeTiles(Tile[] tiles) {
        boolean isChanged=false;
        for (int i = 1; i < tiles.length; i++) {
            if (tiles[i].value == tiles[i - 1].value & tiles[i].value != 0) {
                isChanged = true;
                tiles[i - 1].value *= 2;
                tiles[i].value = 0;
                score += tiles[i - 1].value;
                if (maxTile < tiles[i - 1].value) {
                    maxTile = tiles[i - 1].value;
                }
            }
        }
        compressTiles(tiles);
        return isChanged;
    }
    public void left() {
        if (isSaveNeeded) {
            saveState(gameTiles);
        }
        boolean moveLeft = false;
        for (int i = 0; i < FIELD_WIDTH; i++) {

            if (compressTiles(gameTiles[i])) { moveLeft = true; }
            if (mergeTiles(gameTiles[i])) { moveLeft = true; }
        }
        if (moveLeft) {
            addTile();
        }
        isSaveNeeded = true;
    }

    public void rotation(){
        Tile[][] tempArr = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                tempArr[j][FIELD_WIDTH - 1 - i] = gameTiles[i][j];
            }
        }
        gameTiles = tempArr;
    }
    public void right() {
        saveState(gameTiles);
        rotation();
        rotation();
        left();
        rotation();
        rotation();
    }

    public void up() {
        saveState(gameTiles);
        rotation();
        rotation();
        rotation();
        left();
        rotation();
    }

    public void down() {
        saveState(gameTiles);
        rotation();
        left();
        rotation();
        rotation();
        rotation();
    }

    public boolean canMove() {
        if (!getEmptyTiles().isEmpty()) {
            return true;
        }
        else {
            for (int i = 0; i < FIELD_WIDTH; i++) {
                for (int j = 1; j < FIELD_WIDTH; j++) {
                    if (gameTiles[i][j-1].value == gameTiles[i][j].value) {
                        return true;
                    }
                }
            }
            for (int i = 1; i < FIELD_WIDTH; i++) {
                for (int j = 0; j < FIELD_WIDTH; j++) {
                    if (gameTiles[i-1][j].value == gameTiles[i][j].value) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    private void saveState(Tile[][] tiles) {
        Tile[][] tiles1 = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                tiles1[i][j] = new Tile(tiles[i][j].value);
            }
        }
        previousStates.push(tiles1);
        previousScores.push(score);
        isSaveNeeded = false;
    }

    public void rollback() {
        if (!previousScores.empty()) {
            score = previousScores.pop();
        }
        if (!previousStates.empty()) {
            gameTiles = previousStates.pop();
        }
    }
    public void randomMove() {
        int n = ((int) (Math.random() * 100)) % 4;
        switch (n) {
            case 0:
                left();
                break;
            case 1:
                right();
                break;
            case 2:
                up();
                break;
            case 3:
                down();
                break;
        }
    }

    private boolean hasBoardChanged() {
        Tile[][] tilesStack = previousStates.peek();
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                if (tilesStack[i][j].value != gameTiles[i][j].value) {
                    return true;
                }
            }
        }
        return false;
    }
    private MoveEfficiency getMoveEfficiency(Move move){
        move.move();
        MoveEfficiency moveEfficiency;
        if (hasBoardChanged()) {
            moveEfficiency = new MoveEfficiency(getEmptyTiles().size(), score, move);
        }
        else {
            moveEfficiency = new MoveEfficiency(-1, 0, move);
        }
        rollback();
        return moveEfficiency;
    }

    public void autoMove() {
        Queue<MoveEfficiency> queue = new PriorityQueue<MoveEfficiency>(4, Collections.reverseOrder());
        queue.add(getMoveEfficiency(this::randomMove));
        queue.offer(getMoveEfficiency(this::right));
        queue.offer(getMoveEfficiency(this::up));
        queue.offer(getMoveEfficiency(this::down));
        MoveEfficiency efficientMove = (MoveEfficiency) queue.poll();
        efficientMove.getMove().move();
    }

}
