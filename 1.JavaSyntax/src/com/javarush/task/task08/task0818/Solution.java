package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        //напишите тут ваш код
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("Волков", 1000000);
        map.put("Дурнов", 1);
        map.put("Ебанный", 2);
        map.put("Урод", 3);
        map.put("Заебал", 4);
        map.put("Меня", 5);
        map.put("В", 6);
        map.put("Доску", 7);
        map.put("На", 8);
        map.put("Работе", 9);
        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        //напишите тут ваш код
        HashMap<String, Integer> map2 = new HashMap<String, Integer>(map);
        for (Map.Entry<String, Integer> pair:map2.entrySet()
             ) {
            String key = pair.getKey();
            Integer value = pair.getValue();
            if (value < 500) {
                map.remove(key);
            }
        }
       // System.out.println(map);
    }

    public static void main(String[] args) {
        //HashMap<String, Integer> mapp = createMap();
       // removeItemFromMap(mapp);
    }
}