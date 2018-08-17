package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {list.add(reader.readLine());}
        int max=list.get(0).length(), min=list.get(0).length();
        int imax=0, imin=0;
        for (int i=0; i<list.size();i++){
            if (list.get(i).length()>max) {
                max = list.get(i).length();
                imax=i;
            }
            if (list.get(i).length()<min) {
                min = list.get(i).length();
                imin=i;
            }
        }
        if (imax<imin){
            System.out.println(list.get(imax));
        }
        else{
            System.out.println(list.get(imin));
        }
    }
}
