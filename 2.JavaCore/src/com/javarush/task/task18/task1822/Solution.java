package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        String id = args[0];
        BufferedReader brf = new BufferedReader(new FileReader(fileName));
        //System.out.println(brf.readLine());
        String brfLine = null;
        int i = 0;
        while ((brfLine = brf.readLine()) != null) {
            if (i == 0) {
                brfLine = brfLine.substring(1, brfLine.length());
            }
            //System.out.println(brfLine);
            if (brfLine.startsWith(id + " ")) {
                System.out.println(brfLine);
            }
            i++;
        }
        reader.close();
        brf.close();

    }
}
