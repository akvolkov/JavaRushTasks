package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.FileStorageStrategy;
import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.OurHashMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.StorageStrategy;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Home PC Volkov on 02.08.2018.
 */
public class Solution {
    public static void main (String[] args) {
        testStrategy(new HashMapStorageStrategy(),10000);
        testStrategy(new OurHashMapStorageStrategy(), 10000);
        testStrategy(new FileStorageStrategy(), 10000);
    }

    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        Set<Long> set = new HashSet<>();
        Iterator iterator = strings.iterator();
        while (iterator.hasNext()) {
            set.add(shortener.getId((String) iterator.next()));
        }
        return set;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys){
        Set<String> stringSet = new HashSet<String>();
        Iterator iterator = keys.iterator();
        while (iterator.hasNext()) {
            stringSet.add(shortener.getString((Long) iterator.next()));
        }
        return stringSet;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {
        System.out.println(strategy.getClass().getSimpleName());
        Set<String> stringSet = new HashSet<String>();
        for (int i = 0; i < elementsNumber; i++) {
            stringSet.add(Helper.generateRandomString());
        }
        Shortener shortener = new Shortener(strategy);

        Date currentDate = new Date();
        Set<Long> set = getIds(shortener, stringSet);
        Date newDate = new Date();
        long millis = newDate.getTime() - currentDate.getTime();
        Helper.printMessage(millis + "");

        Date currentDate2 = new Date();
        Set <String> set2 = getStrings(shortener, set);
        Date newDate2 = new Date();
        long millis2 = newDate2.getTime() - currentDate2.getTime();
        Helper.printMessage(millis2 + "");

        if (stringSet.equals(set2)) {
            Helper.printMessage("Тест пройден.");
        }
        else {
            Helper.printMessage("Тест не пройден.");
        }
    }

}
