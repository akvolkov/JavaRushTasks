package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        FileInputStream inputStream = new FileInputStream(s);
        Map <Integer, Integer> map = new HashMap<Integer, Integer>();
        int data;// = inputStream.read();
        //map.put(data, 1);

        while (inputStream.available()>0) {
            data = inputStream.read();
            //System.out.println(data);
           if (map.containsKey(data)) {
               int value = map.get(data);
               value++;
               map.remove(data);
               map.put(data, value);
               //System.out.println("yes" + value);
               // map.put(data, 1);

            }
            else {
               map.put(data, 1);
            }

        }
        //System.out.println(map);
        int max_value=0;
        for (Map.Entry <Integer, Integer> pair:map.entrySet()
             ) {
            if (max_value<pair.getValue()) {
                max_value = pair.getValue();
            }
        }
        //System.out.println(max_value);
        for (Map.Entry <Integer, Integer> pair:map.entrySet()
                ) {
            if (max_value == pair.getValue()) {
                System.out.print(pair.getKey() + " ");
            }
        }

        reader.close();
        inputStream.close();
    }
}
