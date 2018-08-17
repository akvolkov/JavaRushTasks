package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
            // ADD CODE HERE
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String f1 = reader.readLine();
            reader.close();

            BufferedReader br = new BufferedReader(new FileReader(f1));
            int count = 0;
            StringBuilder str = new StringBuilder();
            int chr;
            while (br.ready() ){
                chr = br.read();
                if (Character.isLetter(chr)) {
                    if(str.length() <= "world".length()) {
                        str.append((char) chr);
                    }
                    continue;
                }
                else{
                    if(str.length() > 0 && "world".equals(str.toString())){
                        count++;
                    }
                    str = new StringBuilder();
                }
            }
            if(str.length() > 0 && "world".equals(str.toString())){
                count++;
            }
            br.close();
            System.out.println(count);

    }
}
