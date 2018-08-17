package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        FileInputStream inputStream = new FileInputStream(s);
        int data;
        int count = 0;
        while (inputStream.available()>0) {
            data = inputStream.read();
            if (data == 44) {
                count++;
            }
        }
        reader.close();
        inputStream.close();
        System.out.println(count);
    }

}
