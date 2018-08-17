package com.javarush.task.task29.task2909.car;

/**
 * Created by Home PC Volkov on 21.01.2018.
 */
public class Sedan extends Car {

    public Sedan(int numberOfPassengers) {
        super(SEDAN, numberOfPassengers);
    }

    @Override
    public int getMaxSpeed() {
        return MAX_SEDAN_SPEED;
    }
}
