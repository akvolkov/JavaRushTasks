package com.javarush.task.task26.task2611;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Home PC Volkov on 27.01.2018.
 */
public class Producer implements Runnable {
    private ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap map) {
        this.map = map;
    }



    @Override
    public void run() {
        int count = 1;
        while (true) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println(this.getClass().getName() + " thread was terminated");
            }
            map.put(String.valueOf(count), "Some text for " + count );
            count++;
        }
    }
}
