package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        BufferedReader brf = new BufferedReader(new FileReader(fileName1));
        BufferedWriter bwf = new BufferedWriter(new FileWriter(fileName2));
        while (brf.ready()) {
            int symbol = brf.read();
            if (symbol == 46) {
                bwf.write(33);
            }
            else {
                bwf.write(symbol);
            }
        }
        reader.close();
        brf.close();
        bwf.close();
    }
}
