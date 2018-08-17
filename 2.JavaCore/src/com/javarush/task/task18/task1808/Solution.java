package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine();
        String s2 = reader.readLine();
        String s3 = reader.readLine();
        FileInputStream inputStream = new FileInputStream(s1);
        FileOutputStream outputStream2 = new FileOutputStream(s2);
        FileOutputStream outputStream3 = new FileOutputStream(s3);
        byte[] buffer;
        if (inputStream.available() % 2 == 0) {
            buffer = new byte[inputStream.available() / 2];
        } else {
            buffer = new byte[inputStream.available() / 2 + 1];
        }
        int count1;
        //int count2;
        for (int i = 0; i <= 1; i++) {
            if (i == 0) {
                count1 = inputStream.read(buffer);
                outputStream2.write(buffer, 0, count1);
            } else {
                count1 = inputStream.read(buffer);
                outputStream3.write(buffer, 0, count1);
            }
        }
        reader.close();
        inputStream.close();
        outputStream2.close();
        outputStream3.close();

    }
}
