package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.Waiter;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Home PC Volkov on 02.03.2018.
 */
public class Restaurant {
    private static final int ORDER_CREATING_INTERVAL = 100;
    private final static LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();

    public static void main (String[] args) throws InterruptedException {
        //Tablet tablet0 = new Tablet(0);
        //Tablet tablet1 = new Tablet(1);
        //Tablet tablet2 = new Tablet(2);
        //Tablet tablet3 = new Tablet(3);
        //Tablet tablet4 = new Tablet(4);
        Cook cook = new Cook("Cook1");
        cook.setQueue(orderQueue);
        Cook cook2 = new Cook("Cook2");
        cook2.setQueue(orderQueue);
        //StatisticManager.getInstance().register(cook);
        //StatisticManager.getInstance().register(cook2);
        List<Tablet> tablets = new ArrayList<Tablet>();
        for (int i = 0; i < 5; i++) {
            tablets.add(new Tablet(i));
        }

        //OrderManager orderManager = new OrderManager();
        //for (Tablet tab: tablets
         //    ) {
          //  tab.addObserver(orderManager);
           // cook.addObserver(new Waiter());
            //tab.addObserver(orderManager);
            //cook2.addObserver(new Waiter());
       // }

        RandomOrderGeneratorTask randomOrder = new RandomOrderGeneratorTask(tablets, ORDER_CREATING_INTERVAL);
        Thread treadRandom = new Thread(randomOrder);
        treadRandom.start();

        Thread amigoThread = new Thread(cook);
        amigoThread.start();
        Thread makarevichThread = new Thread(cook2);
        makarevichThread.start();
        Thread.sleep(1000);
        treadRandom.interrupt();



        //tablet.addObserver(cook);
        //cook.addObserver(new Waiter());
        //tablet.createOrder();

        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();
    }
}
