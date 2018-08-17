package com.javarush.task.task27.task2712.kitchen;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by Home PC Volkov on 02.03.2018.
 */
public enum Dish {
    Fish(25),
    Steak(30),
    Soup(15),
    Juice(5),
    Water(3);

    private int duration;

    

    Dish(int i) {
        this.duration = i;
    }

    public int getDuration() {
        return duration;
    }

    public static String allDishesToString() {
        StringBuilder sb = new StringBuilder();
        Dish[] d = Dish.values();
        for (Dish dish: d
             ) {
            sb.append(dish.toString()).append(", ");
        }
        return sb.toString().trim().substring(0, sb.length()-2);
    }
}

