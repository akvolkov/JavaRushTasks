package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        FileInputStream inputStream = new FileInputStream(s);
        ArrayList <Integer> list = new ArrayList<Integer>();
        while (inputStream.available()>0) {
            list.add(inputStream.read());
        }
        Collections.sort(list);
        ArrayList <Integer> list2 = new ArrayList<Integer>(list);
        int i = -1;
        for (Integer l:list
             ) {
            if (i == l) {
                list2.remove(l);
            }
            i=l;

        }
        for (Integer l:list2
             ) {
            System.out.print(l + " ");
        }

        //System.out.println(list2);
        reader.close();
        inputStream.close();
    }
}
