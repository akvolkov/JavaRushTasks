package com.javarush.task.task37.task3702.male;

import com.javarush.task.task37.task3702.Human;

/**
 * Created by Home PC Volkov on 12.07.2018.
 */
public class Man implements Human {
    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{}";
    }
}
