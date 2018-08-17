package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws  Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        String stringForm = "%-8d%-30.30s%-8s%-4s";
        BufferedReader brf = new BufferedReader(new FileReader(fileName));
        ArrayList<String> list = new ArrayList<String>();
        while (brf.ready()) {
            list.add(brf.readLine());
        }
        brf.close();
        int id = 0;
        if (args[0].equals("-c")) {
            if (list.size() > 0) {
                String str = list.get(list.size() - 1);
                id = Integer.parseInt(list.get(list.size() - 1).substring(0, 8).trim());
            }
        }
        id++;
        list.add(String.format(stringForm, id, args[1], args[2], args[3]));
        System.out.println(list);
        BufferedWriter bwf = new BufferedWriter(new FileWriter(fileName));
        for (int i = 0; i < list.size(); i++) {
            bwf.write(list.get(i));
            bwf.newLine();
        }
        bwf.close();




        //String line = String.format("%-8d%-30.30s%-8s%-4s", args[1], args[2], args[3]);
        //System.out.println(line);
    }
}

