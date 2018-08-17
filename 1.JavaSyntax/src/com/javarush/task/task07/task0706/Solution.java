package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int[] array = new int[15];
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        for (int i=0; i<15;i++){
            array[i]= Integer.parseInt(reader.readLine());
        }
        int count_even=0, count_odd=0;
        for (int i=0; i<15;i++){
            //if (i==0) count_even=count_even+array[i];
            if (i%2==0)count_even=count_even+array[i];
            else count_odd=count_odd+array[i];
        }
        if (count_even>count_odd) System.out.println("В домах с четными номерами проживает больше жителей.");
        if (count_odd>count_even) System.out.println("В домах с нечетными номерами проживает больше жителей.");
    }
}
