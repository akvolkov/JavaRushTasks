package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.concurrent.DelayQueue;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ArrayList <Integer>list = new ArrayList();
        int num1 = (int) (Math.random() * 10) + 48;
        int num2 = (int) (Math.random() * 10) + 48;
        int upperCase1 = (int) (Math.random() * 26) + 65;
        int upperCase2 = (int) (Math.random() * 26) + 65;
        int upperCase3 = (int) (Math.random() * 26) + 65;
        int lowerCase1 = (int) (Math.random() * 26) + 97;
        int lowerCase2 = (int) (Math.random() * 26) + 97;
        int lowerCase3 = (int) (Math.random() * 26) + 97;
        list.add(num1);
        list.add(num2);
        list.add(upperCase1);
        list.add(upperCase2);
        list.add(upperCase3);
        list.add(lowerCase1);
        list.add(lowerCase2);
        list.add(lowerCase3);
        Collections.shuffle(list);
        for (int i = 0; i < 8; i++) {
            byteArrayOutputStream.write(list.get(i));
        }

        return byteArrayOutputStream;
     }
}