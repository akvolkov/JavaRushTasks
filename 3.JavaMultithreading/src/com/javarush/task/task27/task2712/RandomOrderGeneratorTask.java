package com.javarush.task.task27.task2712;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Home PC Volkov on 17.03.2018.
 */
public class RandomOrderGeneratorTask implements Runnable{
    private List<Tablet> tablets;
    private int interval;

    public RandomOrderGeneratorTask(List<Tablet> tablets, int interval)
    {
        this.tablets = tablets;
        this.interval = interval;
    }
    @Override
    public void run() {

        int selectTablet = (int) (Math.random()*tablets.size());
        while (true) {
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                //e.printStackTrace();
            }
        }
    }
}
