package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        BufferedReader brf = new BufferedReader(new FileReader(fileName));
        while (brf.ready()) {
            String s = brf.readLine();
            char[] ch = s.toCharArray();
            s = "";
            for (int i = ch.length-1; i >= 0; i--) {
                s = s + ch[i];
            }
            System.out.println(s);
        }
        brf.close();

    }
}
