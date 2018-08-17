package com.javarush.task.task17.task1712;

import java.util.ArrayList;
import java.util.List;

/* 
Ресторан
*/

public class Restaurant {
    public static List<Thread> threads = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        Waiter waiterTarget = new Waiter();// создает объект цель официант
        Thread waiter = new Thread(waiterTarget); // создаем нить
        threads.add(waiter); // в лист тредс добавляем нить

        Cook cookTarget = new Cook(); // создаем повара
        Thread cook = new Thread(cookTarget); // создаем нить повара
        threads.add(cook); //в лист тредс добавляем нить повара

        waiter.start(); // запускаем нить официанат
        cook.start();// запускаем нить повар

        Thread.sleep(2000);// спим 2 сек
        cookTarget.continueWorking = false; //останавливает цикл в нити
        Thread.sleep(500);// спим 0,5 сек
        waiterTarget.continueWorking = false;//останавливает цикл в нити
    }
}
