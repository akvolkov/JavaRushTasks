package com.javarush.task.task18.task1814;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* 
UnsupportedFileName
*/

public class TxtInputStream extends FileInputStream {

    public TxtInputStream(String fileName) throws IOException, UnsupportedFileNameException {
        super(fileName);
        String s = fileName.substring(fileName.length()-1-3);
        //System.out.println(s);
        if (!s.equals(".txt")) {
            super.close();
            throw new UnsupportedFileNameException();

        }
    }


    public static void main(String[] args) {
    }
}

