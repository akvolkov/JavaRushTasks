package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        ArrayList<Integer> list = new ArrayList<Integer>(10);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            list.add(Integer.parseInt(reader.readLine()));
        }
        int count = 1;
        int max = 1;
        //ArrayList<Integer> list2 = new ArrayList<Integer>();
        for (int i = 0; i < 9; i++) {
            if (list.get(i) == list.get(i+1)) {
               count++;
            }
            else {
                count = 1;
            }
            if (max < count) {
                max = count;
            }
        }
        System.out.println(max);

    }
}