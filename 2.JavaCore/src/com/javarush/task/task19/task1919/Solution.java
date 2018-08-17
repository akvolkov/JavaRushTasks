package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader brf = new BufferedReader(new FileReader(args[0]));
        String line = "";
        Map<String, Double> map = new HashMap<String, Double>();
        while ((line = brf.readLine()) != null) {
            String[] arr = line.split(" ");
            double value = Double.parseDouble(arr[1]);
            if (map.containsKey(arr[0])) {
                map.put(arr[0], value + map.get(arr[0])); //добавляем к значению мапа
            }
            else {
                map.put(arr[0], value);
            }
        }
        Map <String, Double> bdMap = new TreeMap<String, Double>(map);
        for (Map.Entry<String, Double> pair : bdMap.entrySet()
             ) {
            String key = pair.getKey();
            Double bdValue = pair.getValue();
            System.out.println(key + " " + bdValue);
        }
        brf.close();
        
        
    }
}