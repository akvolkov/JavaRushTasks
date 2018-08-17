package com.javarush.task.task32.task3210;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws IOException {
        String fileName = args[0];
        int number = Integer.parseInt(args[1]);
        String text = args[2];
        RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
        raf.seek(number);
        byte[] arr = new byte[text.length()];
        raf.read(arr, 0, text.length());
        if (Arrays.equals(arr, text.getBytes())) {
            raf.seek(raf.length());
            raf.write("true".getBytes());
        }
        else {
            raf.seek(raf.length());
            raf.write("false".getBytes());
        }
        raf.close();

    }
}
