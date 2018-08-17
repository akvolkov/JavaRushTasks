package com.javarush.task.task18.task1825;

/* 
Собираем файл
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = null;
        ArrayList <String> list = new ArrayList<String>();
        while (!(fileName = reader.readLine()).equals("end")) {
            list.add(fileName);
            //System.out.println(fileName);
        }
        Collections.sort(list);
        String s = list.get(0);
        s = s.substring(0, list.get(0).length()-6);
        System.out.println(s);
        FileOutputStream outputStream = new FileOutputStream(s);
        for (int i = 0; i < list.size(); i++) {
            FileInputStream inputStream = new FileInputStream(list.get(i));
            byte[] buffer = new byte[inputStream.available()];
            while (inputStream.available() > 0) {
                inputStream.read(buffer);
                outputStream.write(buffer);
            }
            inputStream.close();
        }
        reader.close();
        outputStream.close();

        //Collections.sort(list);
        //System.out.println("end");
        //System.out.println(list);
    }
}
