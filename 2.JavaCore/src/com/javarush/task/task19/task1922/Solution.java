package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        BufferedReader brf = new BufferedReader(new FileReader(fileName));
        String line = "";
        while ((line = brf.readLine()) != null) {
            String[] wordsss = line.split(" ");
            int count = 0;
            for (String strrrr:wordsss
                 ) {
                for (String str:words
                     ) {
                    if (str.equals(strrrr)) {
                        count++;
                    }
                }

            }
            if (count == 2) {
                System.out.println(line);
            }
            count = 0;
        }
        brf.close();

    }
}
