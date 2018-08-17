package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/


import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        FileInputStream inputStream = new FileInputStream(fileName);
        int[] arr = new int[128];
        int code = 0;
        while (inputStream.available() > 0) {
            code = inputStream.read();
            arr[code]++;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                System.out.println((char)i + " " + arr[i]);
            }
        }
        inputStream.close();
    }
}
