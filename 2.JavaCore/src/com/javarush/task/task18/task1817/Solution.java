package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        String s = args[0];
        FileInputStream inputStream = new FileInputStream(s);
        ArrayList <Integer> list = new ArrayList <Integer>();
        while (inputStream.available() > 0) {
            list.add(inputStream.read());
        }
        //System.out.println(list);
        int countSymbols = list.size();
        double countSpace = 0;
        for (Integer symbol:list
             ) {
            if (symbol == 32) {
                countSpace++;
            }
        }
        //System.out.println(countSpace);
        //System.out.println(countSymbols);
        System.out.printf("%.2f", countSpace/countSymbols*100);
        inputStream.close();



    }
}
