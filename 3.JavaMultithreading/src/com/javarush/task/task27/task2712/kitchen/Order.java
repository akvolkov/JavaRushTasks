package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

/**
 * Created by Home PC Volkov on 02.03.2018.
 */
public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        initDishes();
    }

    protected void initDishes() throws IOException {
        this.dishes = ConsoleHelper.getAllDishesForOrder();
    }

    public Tablet getTablet() {
        return tablet;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    @Override
    public String toString() {
        if (dishes == null || dishes.isEmpty()) {
            return "";
        } else {
            return "Your order: " + dishes + " of " + tablet + ", cooking time " + getTotalCookingTime() + "min";
        }
    }

    public int getTotalCookingTime() {
        int sum = 0;
        for (int i = 0; i < dishes.size(); i++) {
            sum += dishes.get(i).getDuration();
        }
        return sum;
    }

    public boolean isEmpty(){
        return dishes.isEmpty();
    }

}
