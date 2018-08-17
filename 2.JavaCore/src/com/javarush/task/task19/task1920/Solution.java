package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
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
        Map<String, BigDecimal> map = new HashMap<String, BigDecimal>();
        while ((line = brf.readLine()) != null) {
            String[] oneline = line.split(" ");
            if (map.containsKey(oneline[0])) {
                BigDecimal value = map.get(oneline[0]);
                map.put(oneline[0], value.add(new BigDecimal(Double.parseDouble(oneline[1]))));
            }
            else {
                // написать, если ключа нет такого
                map.put(oneline[0], new BigDecimal(Double.parseDouble(oneline[1])));
            }  
        }
        String maxkey = "";
        BigDecimal maxvalue = new BigDecimal(0.0);
        maxvalue.setScale(5, BigDecimal.ROUND_HALF_UP);

        Map <String, BigDecimal> maxMap = new TreeMap<String, BigDecimal>();
        for (Map.Entry<String, BigDecimal> pair : map.entrySet()
             ) {
            String key = pair.getKey();
            BigDecimal value = pair.getValue();
            if ((maxvalue.compareTo(value)) == -1) {
                maxMap.clear();
                maxkey = key;
                maxvalue = value;
                maxMap.put(key, value);
            }
            else {
                if ((maxvalue.compareTo(value)) == 0) {
                    maxMap.put(key, value);
                }
            }
            //System.out.println(key + ":" + value);
        }
        for (Map.Entry<String, BigDecimal> pair : maxMap.entrySet()
             ) {
            String key = pair.getKey();
            BigDecimal value = pair.getValue();
            System.out.println(key);
        }
        brf.close();
    }
}
