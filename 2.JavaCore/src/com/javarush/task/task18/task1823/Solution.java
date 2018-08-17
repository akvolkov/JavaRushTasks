package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        ArrayList <ReadThread> list = new ArrayList<ReadThread>();
        while (!(fileName = reader.readLine()).equals("exit")) {
            list.add(new ReadThread(fileName));
        }
        for (ReadThread tr: list
             ) {
            tr.start();
        }

        reader.close();
        System.out.println(resultMap);

    }

    public static class ReadThread extends Thread {
        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут
        String fileName;

        @Override
        public void run() {
            try {
                FileInputStream inputStream = new FileInputStream(fileName);
                int bytesymbol = -1;
                Map <Integer, Integer> map = new HashMap<Integer, Integer>();
                while (inputStream.available() > 0) {
                    bytesymbol = inputStream.read();
                    if (map.containsKey(bytesymbol)) {
                        int i = map.get(bytesymbol);
                        i++;
                        map.put(bytesymbol, i);
                    }
                    else {
                        map.put(bytesymbol, 1);
                    }
                }
                int maxValue = 0;
                int maxKey = -1;
                for (Map.Entry <Integer, Integer> pair : map.entrySet()
                     ) {
                    int key = pair.getKey();
                    int value = pair.getValue();
                    if (value > maxValue) {
                        maxValue = value;
                        maxKey = key;
                    }
                }
                resultMap.put(fileName, maxKey);
                inputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }



        }
    }
}
