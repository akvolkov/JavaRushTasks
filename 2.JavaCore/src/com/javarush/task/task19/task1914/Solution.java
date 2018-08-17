package com.javarush.task.task19.task1914;

/* 
Решаем пример
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
        String result = outputStream.toString();
        System.setOut(consoleStream);
        String[] lines = result.split(" ");
        int a = Integer.parseInt(lines[0]);
        int b = Integer.parseInt(lines[2]);
        int summa = 0;
        if (lines[1].equals("+")) {
            summa = a + b;
        }
        if (lines[1].equals("-")) {
            summa = a - b;
        }
        if (lines[1].equals("*")) {
            summa = a * b;
        }
        lines[4] = Integer.toString(summa);
        result = "";
        for (int i = 0; i < lines.length; i++) {
            result = result + lines[i] + " ";
            //System.out.println(i + " " +lines[i]);
        }


        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

