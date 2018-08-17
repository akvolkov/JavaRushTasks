package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader brf = new BufferedReader(new FileReader(args[0]));
        BufferedWriter bwf = new BufferedWriter(new FileWriter(args[1]));
        String line = "";
        String result = "";
        while ((line = brf.readLine()) != null) {
            String[] words = line.split(" ");
            for (int i = 0; i < words.length; i++) {
                if (testWords(words[i]) == true) {
                    result += words[i] + " ";
                }
            }
        }
        bwf.write(result);
        brf.close();
        bwf.close();
    }

    private static Boolean testWords (String str) {
        if (str.contains("0")|| str.contains("1") || str.contains("2") || str.contains("3") || str.contains("4")
                || str.contains("5") || str.contains("6") || str.contains("7") || str.contains("8") || str.contains("9")

                ) {
            return true;
        }
        else {
            return false;
        }
    }
}
