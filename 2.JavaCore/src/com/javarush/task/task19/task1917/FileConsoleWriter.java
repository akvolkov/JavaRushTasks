package com.javarush.task.task19.task1917;

/* 
Свой FileWriter
*/

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;

public class FileConsoleWriter {
    private FileWriter fileWriter;


    public void write(int c) throws IOException {
        //super.write(c);
        fileWriter.write(c);
        System.out.print(c);
    }


    public void write(char[] cbuf, int off, int len) throws IOException {
        //super.write(cbuf, off, len);
        fileWriter.write(cbuf, off, len);
        System.out.println(String.valueOf(cbuf).substring(off,off+len));
    }


    public void write(String str, int off, int len) throws IOException {
        //super.write(str, off, len);
        fileWriter.write(str, off, len);
        System.out.println(str.substring(off,off + len));
    }

    public void write(char[] cbuf) throws IOException {
        //super.write(cbuf);
        fileWriter.write(cbuf);
        for (int i = 0; i < cbuf.length; i++) {
            System.out.print(cbuf[i]);
        }
    }


    public void write(String str) throws IOException {
        //super.write(str);
        fileWriter.write(str);
        System.out.println(str);
    }

    public FileConsoleWriter(String fileName) throws IOException {
        //super(fileName);
        fileWriter = new FileWriter(fileName);

    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException {
        //super(fileName, append);
        fileWriter = new FileWriter(fileName,append)   ;
    }

    public FileConsoleWriter(File file) throws IOException {
        //super(file);
        fileWriter = new FileWriter(file);
    }


    public void close() throws IOException {
        //super.close();
        fileWriter.close();

    }

    public FileConsoleWriter(File file, boolean append) throws IOException {
        //super(file, append);
        fileWriter =new FileWriter(file, append);
    }

    public FileConsoleWriter(FileDescriptor fd) {
        //super(fd);
        fileWriter = new FileWriter(fd);
    }

    public static void main(String[] args) {

    }

}
