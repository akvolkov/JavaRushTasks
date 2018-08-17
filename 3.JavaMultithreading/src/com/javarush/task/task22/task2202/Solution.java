package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
        //System.out.println(getPartOfString("JavaRush - лучший"));
    }

    public static String getPartOfString(String string) {
        if (string == null || string.isEmpty()) throw new TooShortStringException();
        int findSpace = string.indexOf(" ");
        for (int i = 1; i < 4; i++) {
            if ((findSpace = string.indexOf(" ", findSpace + 1)) == -1)
                throw new TooShortStringException();
        }
        String s[] = string.split(" ");
        return s[1] + " " + s[2] + " " + s[3] + " " +  s[4];



        /*int index = string.indexOf(' ');
        String str = string;
        if (index != -1) {
            str = string.substring(index+1);
        }
        String sub = "";
        while (string.indexOf(' ') != -1) {

        }

            for (int i = 1; i < 4; i++) {
                index = string.indexOf(' ');
                if (index != -1) {
                    sub = sub + str.substring(0, index);
                    str = str.substring(index);
                }
            }*/


        //return sub;
    }

    public static class TooShortStringException extends RuntimeException{
    }
}
