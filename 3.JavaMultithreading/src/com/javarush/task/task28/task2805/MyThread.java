package com.javarush.task.task28.task2805;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Home PC Volkov on 18.02.2018.
 */
public class MyThread extends Thread {
    public static AtomicInteger atomicInteger = new AtomicInteger(0);
    public MyThread() {
        if (atomicInteger.get() == 10) {
            atomicInteger.set(0);
        }
        this.setPriority(atomicInteger.incrementAndGet());
    }

    public MyThread(Runnable target) {
        super(target);
        if (atomicInteger.get() == 10) {
            atomicInteger.set(0);
        }
        this.setPriority(atomicInteger.incrementAndGet());
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        if (atomicInteger.get() == 10) {
            atomicInteger.set(0);
        }
        this.setPriority(atomicInteger.incrementAndGet());
        if (this.getPriority() > group.getMaxPriority()) {
            this.setPriority(group.getMaxPriority());

        }
    }

    public MyThread(String name) {
        super(name);
        if (atomicInteger.get() == 10) {
            atomicInteger.set(0);
        }
        this.setPriority(atomicInteger.incrementAndGet());
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        if (atomicInteger.get() == 10) {
            atomicInteger.set(0);
        }
        this.setPriority(atomicInteger.incrementAndGet());
        if (this.getPriority() > group.getMaxPriority()) {
            this.setPriority(group.getMaxPriority());

        }
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        if (atomicInteger.get() == 10) {
            atomicInteger.set(0);
        }
        this.setPriority(atomicInteger.incrementAndGet());
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        if (atomicInteger.get() == 10) {
            atomicInteger.set(0);
        }
        this.setPriority(atomicInteger.incrementAndGet());
        if (this.getPriority() > group.getMaxPriority()) {
            this.setPriority(group.getMaxPriority());

        }
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        if (atomicInteger.get() == 10) {
            atomicInteger.set(0);
        }
        this.setPriority(atomicInteger.incrementAndGet());
        if (this.getPriority() > group.getMaxPriority()) {
            this.setPriority(group.getMaxPriority());

        }
    }
}
