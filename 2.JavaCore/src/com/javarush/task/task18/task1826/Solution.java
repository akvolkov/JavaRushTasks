package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args[0].equals("-e")) {
            encryption(args[1], args[2]);
        }
        if (args[0].equals("-d")) {
            decipher(args[1], args[2]);
        }
    }
    private static void encryption (String fileName, String fileOutputName) throws IOException {
        FileInputStream fis = new FileInputStream(fileName);
        byte[] buffer = new byte[fis.available()];
        while (fis.available() > 0) {
            fis.read(buffer);
        }
        fis.close();
        for (int i = 0; i < buffer.length; i++) {
            buffer[i]++;
        }
        FileOutputStream fos = new FileOutputStream(fileOutputName);
        for (int i = 0; i < buffer.length; i++) {
            fos.write(buffer[i]);
        }
        fos.close();
    }
    private static void decipher (String fileName, String fileOutputName) throws IOException {
        FileInputStream fis = new FileInputStream(fileName);
        byte[] buffer = new byte[fis.available()];
        while (fis.available() > 0) {
            fis.read(buffer);
        }
        fis.close();
        for (int i = 0; i < buffer.length; i++) {
            buffer[i]--;
        }
        FileOutputStream fos = new FileOutputStream(fileOutputName);
        for (int i = 0; i < buffer.length; i++) {
            fos.write(buffer[i]);
        }
        fos.close();
    }

}
