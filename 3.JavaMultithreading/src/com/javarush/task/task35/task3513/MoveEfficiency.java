package com.javarush.task.task35.task3513;

/**
 * Created by Home PC Volkov on 06.04.2018.
 */
public class MoveEfficiency implements Comparable<MoveEfficiency>{
    private int numberOfEmptyTiles;
    private int score;
    private Move move;

    public MoveEfficiency(int numberOfEmptyTiles, int score, Move move) {
        this.numberOfEmptyTiles = numberOfEmptyTiles;
        this.score = score;
        this.move = move;
    }

    public Move getMove() {
        return move;
    }


    @Override
    public int compareTo(MoveEfficiency o) {
        int i = Integer.compare(this.numberOfEmptyTiles, o.numberOfEmptyTiles);
        if (i != 0) {
            return i;
        }
        else {
            return Integer.compare(this.score, o.score);
        }
    }
}
