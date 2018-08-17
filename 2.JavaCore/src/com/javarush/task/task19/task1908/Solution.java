package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        BufferedReader brf = new BufferedReader(new FileReader(fileName1));
        BufferedWriter bwf = new BufferedWriter(new FileWriter(fileName2));
        String line;
        String[] words;
        while (brf.ready()) {
            line = brf.readLine();
            words = line.split(" ");
            for (int i = 0; i < words.length; i++) {
                try {
                    Integer.parseInt(words[i]);
                    bwf.write(words[i]);
                    bwf.write(" ");
                }
                catch (NumberFormatException e) {

                }

            }

        }
        reader.close();
        brf.close();
        bwf.close();
    }
}
