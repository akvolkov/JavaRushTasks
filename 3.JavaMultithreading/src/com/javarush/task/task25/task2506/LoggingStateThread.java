package com.javarush.task.task25.task2506;

/**
 * Created by Home PC Volkov on 13.01.2018.
 */
public class LoggingStateThread extends Thread{
    Thread tr;
    public LoggingStateThread(Thread target) {
        this.tr = target;
    }

    @Override
    public void run() {
        State state = tr.getState();
        System.out.println(tr.getState());
        while (tr.getState()!=State.TERMINATED) {
            if (state != tr.getState()) {
                System.out.println(tr.getState());
                state = tr.getState();
            }

        }

    }
}
