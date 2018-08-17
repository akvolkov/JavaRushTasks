package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null || string.isEmpty()) throw new TooShortStringException();
        int indexStart = string.indexOf('\t');
        try {
            String str = string.substring(indexStart+1);
            //System.out.println(str);
            indexStart = str.indexOf('\t');
            str = str.substring(0, indexStart);
            //System.out.println(str);
            return str;
        }
        catch (Exception e) {
            throw new TooShortStringException();
        }
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
        System.out.println(getPartOfString("\tJavaRush - лучший сервис "));
}
}
