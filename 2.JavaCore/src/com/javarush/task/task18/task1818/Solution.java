package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        String fileName3 = reader.readLine();
        //BufferedReader reader2 = new BufferedReader(new FileReader(fileName2));
        //BufferedReader reader3 = new BufferedReader(new FileReader(fileName3));
        FileInputStream inputStream2 = new FileInputStream(fileName2);
        FileInputStream inputStream3 = new FileInputStream(fileName3);
        //BufferedWriter writer = new BufferedWriter(new FileWriter(fileName1));
        FileOutputStream outputStream1 = new FileOutputStream(fileName1, true);
        //ArrayList<Integer> list = new ArrayList<Integer>();
        int b;
        while (inputStream2.available()>0) {
            b = inputStream2.read();
            outputStream1.write(b);
        }
        while (inputStream3.available()>0) {
            b = inputStream3.read();
            outputStream1.write(b);
        }
        //System.out.println(list);

        //    outputStream1.write(list.get(i));

        reader.close();
        inputStream2.close();
        inputStream3.close();
        outputStream1.close();
    }
}
