package com.javarush.task.task19.task1906;

/* 
Четные байты
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        FileReader fr = new FileReader(fileName1);
        FileWriter fw = new FileWriter(fileName2);
        //char[] cbuf = new char[1000];
        int count = 0;
        int symbol;
        while (fr.ready()) {
            symbol = fr.read();
            if (count == 0) {
                count = 1;
            }
            else {
                count = 0;
                fw.write(symbol);
            }

        }
        fr.close();
        fw.close();
        reader.close();
    }
}
