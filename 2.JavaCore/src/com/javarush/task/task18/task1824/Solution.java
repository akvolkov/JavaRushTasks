package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = null;
        while (true) {
            try {
                fileName = reader.readLine();
                FileInputStream in = new FileInputStream(fileName);
                in.close();
            } catch (FileNotFoundException e) {
                System.out.println(fileName);
                reader.close();
                break;
            }


        }



    }
}
