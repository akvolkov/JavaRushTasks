package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        byte[] arr = outputStream.toByteArray();
        String result = outputStream.toString();
        String[] res = result.split("\n");
        int count = 0;
        result = "";
        for (int i = 0; i < res.length; i++) {
            result = result + res[i] + "\r\n";
            count++;
            if (count == 2) {
                result = result + "JavaRush - курсы Java онлайн\r\n";
                count = 0;
            }
        }
        System.setOut(consoleStream);
        System.out.print(result);

        /*for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(res.length);*/

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
