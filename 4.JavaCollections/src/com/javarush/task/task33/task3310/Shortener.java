package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.StorageStrategy;

/**
 * Created by Home PC Volkov on 02.08.2018.
 */
public class Shortener{
    private Long lastId = (long)0;
    private StorageStrategy storageStrategy;
    public synchronized Long getId(String string) {
        if (storageStrategy.containsValue(string)) {
            return storageStrategy.getKey(string);
        }
        else {
            lastId++;
            storageStrategy.put(lastId, string);
            return lastId;
        }

    }

    public Shortener(StorageStrategy storageStrategy) {
        this.storageStrategy = storageStrategy;
    }

    public synchronized String getString(Long id) {
        return storageStrategy.getValue(id);
    }




}
