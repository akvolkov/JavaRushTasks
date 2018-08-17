package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        FileInputStream inputStream1 = new FileInputStream(file1);
        byte[] buffer = new byte[inputStream1.available()];
        while (inputStream1.available()>0) {
            inputStream1.read(buffer);
        }
        FileOutputStream outputStream1 = new FileOutputStream(file1,true);
        FileInputStream inputStream2 = new FileInputStream(file2);
        while (inputStream2.available()>0) {
            int Symbol = inputStream2.read();
            outputStream1.write(Symbol);
        }
        for (int i = 0; i < buffer.length; i++) {
            outputStream1.write(buffer[i]);
        }
        reader.close();
        inputStream1.close();
        outputStream1.close();
        inputStream2.close();

    }
}
