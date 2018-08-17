package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;
import java.util.SimpleTimeZone;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        BufferedReader brf = new BufferedReader(new FileReader(fileName1));
        BufferedWriter bwf = new BufferedWriter(new FileWriter(fileName2));
        while (brf.ready()) {
            int data = (char) brf.read();
            if (Character.isAlphabetic(data)) {
                bwf.write(data);
            }
        }
        reader.close();
        brf.close();
        bwf.close();

    }
}
