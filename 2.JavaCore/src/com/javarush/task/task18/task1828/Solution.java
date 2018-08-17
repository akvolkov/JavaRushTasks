package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        if (args[0].equals("-d")) {
            delete(args, fileName);
        }
        if (args[0].equals("-u")) {
            update(fileName, args);
        }
    }
    private static void update (String fileName, String[] args) throws IOException {
        BufferedReader brf = new BufferedReader(new FileReader(fileName));
        String str;
        ArrayList<String> list = new ArrayList<String>();
        while ((str = brf.readLine()) != null) {
            list.add(str);
        }
        brf.close();
        int id = Integer.parseInt(args[1]);
        for (int i = 0; i < list.size(); i++) {
            if (id == writeId(list.get(i))) {
                String line = String.format("%-8d%-30.30s%-8s%-4s", id, args[2], args[3], args[4]);
                list.set(i, line);
            }
        }
        BufferedWriter bwf = new BufferedWriter(new FileWriter(fileName));
        for (int i = 0; i < list.size(); i++) {
            bwf.write(list.get(i));
            bwf.newLine();
        }
        bwf.close();
        //System.out.println(list);
    }
    private static void delete (String[] args, String fileName) throws IOException {
        BufferedReader brf = new BufferedReader(new FileReader(fileName));
        String str;
        ArrayList<String> list = new ArrayList<String>();
        while ((str = brf.readLine()) != null) {
            list.add(str);
        }
        brf.close();
        int id = Integer.parseInt(args[1]);
        for (int i = 0; i < list.size(); i++) {
            if (id == writeId(list.get(i))) {
                list.remove(i);
            }
        }
        BufferedWriter bwf = new BufferedWriter(new FileWriter(fileName));
        for (int i = 0; i < list.size(); i++) {
            bwf.write(list.get(i));
            bwf.newLine();
        }
        bwf.close();
        //System.out.println(list);
    }
    private static int writeId (String str) {
        String newString = str.substring(0, 8).trim();
        int id = Integer.parseInt(newString);
        return id;
    }
}
