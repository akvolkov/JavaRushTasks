package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameFile1;
        String nameFile2;
        nameFile1 = reader.readLine();
        nameFile2 = reader.readLine();
        BufferedReader fileReader1 = new BufferedReader(new FileReader(nameFile1));
        BufferedReader fileReader2 = new BufferedReader(new FileReader(nameFile2));
        String line;
        while ((line = fileReader1.readLine())!=null) {
            allLines.add(line);
        }
        String line2;
        while ((line2 = fileReader2.readLine())!=null) {
            forRemoveLines.add(line2);
        }
        reader.close();
        fileReader1.close();
        fileReader2.close();
        //System.out.println(allLines);
       // System.out.println(forRemoveLines);

        new Solution().joinData();

    }

    public void joinData () throws CorruptedDataException {
        Boolean lable = true;
        //List<String> allLines2 = new ArrayList<String>(allLines);
        for (int i =0 ;i < forRemoveLines.size();i++) {
            if (allLines.contains(forRemoveLines.get(i))) {
                allLines.remove(forRemoveLines.get(i));
            }
            else {
                lable = false;
                allLines.clear();
                throw new CorruptedDataException();
            }
        }
        //System.out.println(allLines);
       // System.out.println(forRemoveLines);

    }
}
