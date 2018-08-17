package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {
        String s = args[0];
        FileInputStream inputStream = new FileInputStream(s);
        ArrayList<Integer> list = new ArrayList <Integer>();
        while (inputStream.available()>0) {
            //System.out.println(inputStream.read());
            list.add(inputStream.read());
        }
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            int val = list.get(i);
            if ((val > 96 && val < 123) || (val > 64 && val < 91)) {
                count++;
            }
        }
        /*Map <Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < 26; i++) {
            map.put(97+i, 0);
        }
        for (int i = 0; i < 26; i++) {
            map.put(65+i, 0);
        }
        //System.out.println(map);
        for (int i = 0; i < list.size(); i++) {
            int val = list.get(i);
            if ((val > 96 && val < 123) || (val > 64 && val < 91)) {
                //System.out.println(val);
                int count = map.get(val);
                count++;
                map.put(val, count);
            }
        }
        //System.out.println(map);
        int count = 0;
        for (Map.Entry <Integer, Integer> pair:map.entrySet()
             ) {
            if (pair.getValue() > 0) {
                count++;
            }
        }*/
        inputStream.close();
        System.out.println(count);



    }
}
