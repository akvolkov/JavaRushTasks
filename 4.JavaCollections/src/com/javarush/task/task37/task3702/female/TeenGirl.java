package com.javarush.task.task37.task3702.female;

import com.javarush.task.task37.task3702.Human;

/**
 * Created by Home PC Volkov on 12.07.2018.
 */
public class TeenGirl implements Human {
    public static final int MAX_AGE = 19;
    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{}";
    }
}
