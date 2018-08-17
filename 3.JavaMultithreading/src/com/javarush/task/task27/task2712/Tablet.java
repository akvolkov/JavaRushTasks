package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.ad.NoVideoAvailableException;
import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.TestOrder;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.io.IOException;
import java.util.Observable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Home PC Volkov on 02.03.2018.
 */
public class Tablet {
    private final int number;
    static Logger logger = Logger.getLogger(Tablet.class.getName());
    Order order = null;
    private LinkedBlockingQueue<Order> queue;

    public Tablet(int number) {
        this.number = number;

    }

    public void setQueue(LinkedBlockingQueue<Order> queue) {
        this.queue = queue;
    }

    @Override
    public String toString() {

        return "Tablet{" +
                "number=" + number +
                '}';
    }

    public Order createOrder() {
        Order order = null;
        try {
            order = new Order(this);
            createe(order, order.getTotalCookingTime() * 60);

            return order;
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }
        catch (NoVideoAvailableException e) {
            logger.log(Level.INFO,  "No video is available for the order " + order);
        }
        return order;
    }

    public void createTestOrder() {
        try {
            order = new TestOrder(this);
            createe(order, order.getTotalCookingTime() * 60);

            //return order;
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }
        catch (NoVideoAvailableException e) {
            logger.log(Level.INFO,  "No video is available for the order " + order);
        }
        //return order;
        //будет случайным образом генерировать заказ со случайными блюдами не общаясь с реальным человеком.
        //Все необходимые данные передай в конструкторе.
    }

    private void createe(Order order, int timeSeconds) {
        //if (!order.isEmpty()) {
            //setChanged();
            //notifyObservers(order);
            AdvertisementManager manager = new AdvertisementManager(timeSeconds);

            manager.processVideos();
        queue.add(order);

        //}
    }

}
