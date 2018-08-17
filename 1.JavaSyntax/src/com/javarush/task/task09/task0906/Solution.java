package com.javarush.task.task09.task0906;

/* 
Логирование стек трейса
*/

public class Solution {
    public static void main(String[] args) {
        log("In main method");
    }

    public static void log(String s) {
        //напишите тут ваш код
        StackTraceElement[] sttrel = Thread.currentThread().getStackTrace();
        System.out.println(sttrel[2].getClassName() + ": " + sttrel[2].getMethodName() + ": " + s);

        /*for (StackTraceElement element:sttrel
             ) {
            System.out.println(element.getClassName() + ": " + element.getMethodName());
        }*/
    }
}
