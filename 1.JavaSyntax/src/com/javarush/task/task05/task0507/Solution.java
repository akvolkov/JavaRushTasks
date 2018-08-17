package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list =new ArrayList<Integer>();
        int n, summa=0;
        while ((n=Integer.parseInt(reader.readLine()))!=-1){
            list.add(n);
        }
        for (int x:list
             ) {
            summa+=x;
        }

        System.out.println(1.0*summa/list.size());
    }
}

