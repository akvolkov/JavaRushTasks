package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        FileReader in = new FileReader(fileName);
        String line = "";
        int symbol;
        while (in.ready()) {
            symbol = in.read();
            if (!((char)symbol == '\n') && !((char)symbol == '\r')) {
                line = line + (char) symbol;
            }
        }
        in.close();
        ArrayList<Integer> listOpen = findIndex ("<" + args[0] , line);
        ArrayList<Integer> listClose = findIndex ("</" + args[0] + ">", line);
        Map <Integer, Character> map = new TreeMap<Integer, Character>();
        for (int i = 0; i < listOpen.size(); i++) {
            map.put(listOpen.get(i), 'o');
        }
        for (int i = 0; i < listClose.size(); i++) {
            map.put(listClose.get(i), 'c');
        }
        Integer ikey = 0;
        Character ivalue = 'r';
        Integer keyOpenRemove = null, keyCloseRemove = null;
        Map <Integer, String> mapResult = new TreeMap<Integer, String>();
        for (int i = 0; i < listClose.size(); i++) {
            Iterator<Map.Entry<Integer, Character>> entries = map.entrySet().iterator();
            while (entries.hasNext()) {
                Map.Entry<Integer, Character> entry = entries.next();
                Integer key = entry.getKey();
                Character value = entry.getValue();
                if (ivalue == 'o' && value == 'c') {
                    String result = line.substring(ikey, key + 3 + args[0].length());
                    keyOpenRemove = ikey;
                    keyCloseRemove = key;
                    mapResult.put(ikey, result);
                }
                ikey = key;
                ivalue = value;
            }
                map.remove(keyOpenRemove);
                map.remove(keyCloseRemove);
        }
        for (Map.Entry<Integer, String> pair: mapResult.entrySet()
             ) {
                System.out.println(pair.getValue());
        }
    }
    private static ArrayList<Integer> findIndex (String teg, String line) {
        ArrayList <Integer> list = new ArrayList<Integer>();
        String line1 = line;
        int count = 0;
        while (line1.indexOf(teg) != -1) {
            int indexTeg = line1.indexOf(teg);
            //System.out.println(indexTeg);
            count += indexTeg;
            list.add(count);
            line1 = line1.substring(indexTeg + teg.length());
            count += teg.length();
        }
        return list;
    }
}
