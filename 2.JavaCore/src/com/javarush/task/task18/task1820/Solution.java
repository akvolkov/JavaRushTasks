package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        BufferedReader br = new BufferedReader(new FileReader(fileName1));
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName2));
        String s;
        while ((s = br.readLine())!=null) {
            String[] arrStr = s.split(" ");
            for (int i = 0; i < arrStr.length; i++) {
                System.out.println(arrStr[i]);
                int strTodbltoInt = (int)Math.round(Double.parseDouble(arrStr[i]));
                System.out.println(strTodbltoInt);
                bw.write(String.valueOf(strTodbltoInt));
                bw.write(" ");
            }
        }
        bw.close();
        br.close();
        reader.close();
    }
}
