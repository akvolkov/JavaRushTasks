package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine();
        String s2 = reader.readLine();
        FileInputStream inputStream = new FileInputStream(s1);
        FileOutputStream outputStream = new FileOutputStream(s2);
        byte[] buffer = new byte[inputStream.available()];
        byte[] buffer2 = new byte[inputStream.available()];
        while (inputStream.available() > 0) {
            int count = inputStream.read(buffer);
            for (int i = 0; i < buffer.length; i++) {
                buffer2[buffer2.length-1-i] = buffer[i];
            }
            outputStream.write(buffer2, 0, count);
        }

        reader.close();
        inputStream.close();
        outputStream.close();
    }
}
