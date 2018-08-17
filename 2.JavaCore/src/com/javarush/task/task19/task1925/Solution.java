package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName1 = args[0];
        String fileName2 = args[1];
        BufferedReader brf = new BufferedReader(new FileReader(fileName1));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName2));
        String line = null;
        String result = "";
        while ((line = brf.readLine()) != null) {
            String[] words = line.split(" ");
            for (int i = 0; i < words.length; i++) {
                if (words[i].length() > 6) {
                    result += words[i] + ",";
                }
            }
        }
        //System.out.println(result);
        result = result.substring(0, result.length()-1);
       // System.out.println(result);
        bufferedWriter.write(result);
        brf.close();
        bufferedWriter.close();
    }
}
