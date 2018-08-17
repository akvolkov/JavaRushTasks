package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Home PC Volkov on 08.03.2018.
 */
public class Cook extends Observable implements Runnable {

    private String name;
    private boolean busy;
    private LinkedBlockingQueue<Order> queue = new LinkedBlockingQueue<Order>();

    public void setQueue(LinkedBlockingQueue<Order> queue) {
        this.queue = queue;
    }

    public boolean isBusy() {return busy;}

    public Cook(String name) {
        this.name = name;}

    @Override
    public String toString() {return name;}

    public void startCookingOrder(Order order) {
        busy = true;
        int orderTime = order.getTotalCookingTime();
        ConsoleHelper.writeMessage("Start cooking - " + order + ", cooking time " + orderTime + "min");
        CookedOrderEventDataRow eventDataRow = new CookedOrderEventDataRow(order.getTablet().toString(), name, orderTime * 60, order.getDishes());
        StatisticManager.getInstance().register(eventDataRow);
        setChanged();
        notifyObservers(order);
        try {
            Thread.sleep(orderTime * 10);
        } catch (InterruptedException e) {
        }
        this.busy = false;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted())
        {
            if (!queue.isEmpty())
            {
                Order order = queue.poll();
                if (order != null)
                {
                    this.startCookingOrder(order);
                }
                try
                {
                    Thread.sleep(10);
                }
                catch (InterruptedException e)
                {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}