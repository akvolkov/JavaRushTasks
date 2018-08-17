package com.javarush.task.task17.task1719;

import java.util.HashMap;
import java.util.Map;

/* 
ApplicationContext
*/

public abstract class ApplicationContext<GenericsBean extends Bean> {
    private volatile Map<String, GenericsBean> container = new HashMap<String, GenericsBean>();//создаем Мэп из Стрингов и ДженериксБин
    //Map<Name, some class implemented Bean interface>


    protected ApplicationContext() {
        parseAllClassesAndInterfaces();
    }//конструктор вызывает метод

    public synchronized GenericsBean getByName(String name) {
          return container.get(name);
    }

    public synchronized GenericsBean removeByName(String name) {
        return container.remove(name);
    }

    protected abstract void parseAllClassesAndInterfaces();

    public static void main(String[] args) {

    }
}
