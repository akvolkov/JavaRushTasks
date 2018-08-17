package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        FileInputStream inputStream = new FileInputStream(s);
        int max = 0;
        int data;
        while (inputStream.available()>0) {
            data = inputStream.read();
            //System.out.println(data);
            if (data > max) {
                max = data;
            }
        }
        System.out.println(max);
        reader.close();
        inputStream.close();

    }
}
