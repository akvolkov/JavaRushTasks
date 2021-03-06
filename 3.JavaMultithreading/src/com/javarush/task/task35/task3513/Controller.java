package com.javarush.task.task35.task3513;

import com.sun.org.apache.xpath.internal.operations.Mod;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by Home PC Volkov on 31.03.2018.
 */
public class Controller extends KeyAdapter {
    private Model model;
    private View view;
    private final static int WINNING_TILE = 2048;

    public Controller(Model model) {
        this.model = model;
        this.view = new View(this);
    }

    public Tile[][] getGameTiles() {
        return model.getGameTiles();
    }
    public int getScore() {
        return model.score;
    }

    public void resetGame() {
        model.score = 0;
        view.isGameLost = false;
        view.isGameWon = false;
        model.resetGameTiles();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            resetGame();
        }
        if (model.canMove() == false) {
            view.isGameLost = true;
        }
        else {
            if (view.isGameLost == false && view.isGameWon == false) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        model.left();
                        break;
                    case KeyEvent.VK_RIGHT:
                        model.right();
                        break;
                    case KeyEvent.VK_UP:
                        model.up();
                        break;
                    case KeyEvent.VK_DOWN:
                        model.down();
                        break;
                    case KeyEvent.VK_Z:
                        model.rollback();
                        break;
                    case KeyEvent.VK_R:
                        model.randomMove();
                        break;
                    case KeyEvent.VK_A:
                        model.autoMove();
                        break;
                }
            }
        }
        if (model.maxTile == WINNING_TILE) {
            view.isGameWon = true;
        }
        view.repaint();
    }

    public View getView() {
        return view;
    }
}
