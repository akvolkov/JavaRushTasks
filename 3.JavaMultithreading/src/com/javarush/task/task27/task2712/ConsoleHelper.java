package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Home PC Volkov on 02.03.2018.
 */
public class ConsoleHelper {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {

            return reader.readLine();

    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        writeMessage(Dish.allDishesToString());
        writeMessage("Введите желаемое блюдо: ");
        String dish = readString();
        List<Dish> dishes = new ArrayList<Dish>();
        while (!dish.equals("exit")) {
            try {
                Dish dishEnum = Dish.valueOf(dish);
                dishes.add(dishEnum);
            }
            catch (Exception e) {
                writeMessage("данного блюда нет в списке, введите снова");
            }
            dish = readString();
        }
        return dishes;
    }

}
