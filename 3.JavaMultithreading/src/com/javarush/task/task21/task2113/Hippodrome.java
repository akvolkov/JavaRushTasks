package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Home PC Volkov on 18.04.2017.
 */
public class Hippodrome {
    static public Hippodrome game;
    private List<Horse> horses;
    public Hippodrome (List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public static void main (String[] args) throws InterruptedException {
        game = new Hippodrome(new ArrayList<Horse>());
        Horse horse1 = new Horse("horse1", 3, 0);
        Horse horse2 = new Horse("horse2", 3, 0);
        Horse horse3 = new Horse("horse3", 3, 0);
        game.getHorses().add(horse1);
        game.getHorses().add(horse2);
        game.getHorses().add(horse3);
        game.run();
        game.printWinner();
    }
    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            this.move();
            this.print();
            Thread.sleep(200);
        }
    }
    public void move() {
        for (int i = 0; i < this.getHorses().size(); i++) {
            this.getHorses().get(i).move();
        }
    }
    public void print() {
        for (int i = 0; i < this.getHorses().size(); i++) {
            this.getHorses().get(i).print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }
    public Horse getWinner() {
        double dist1 = this.getHorses().get(0).getDistance();
        double dist2 = this.getHorses().get(1).getDistance();
        double dist3 = this.getHorses().get(2).getDistance();
        if (dist1 >= dist2 && dist1 >= dist3) {
            return this.getHorses().get(0);
        }
        else {
            if (dist2 >= dist1 && dist2 >= dist3) {
                return this.getHorses().get(1);
            }
            else return this.getHorses().get(2);
        }

    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }
}
