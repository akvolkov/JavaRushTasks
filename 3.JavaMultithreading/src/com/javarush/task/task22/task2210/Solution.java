package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {
        String query = "level22.lesson13.task01";
        String delimiter = ".";
        String[] token = getTokens(query, delimiter);
        for (int i = 0; i < token.length; i++) {
            System.out.println(token[i]);
        }
    }
    public static String [] getTokens(String query, String delimiter) {
        ArrayList<String> list = new ArrayList<String>();
        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
        while (tokenizer.hasMoreTokens()) {
            String tok = tokenizer.nextToken();
            list.add(tok);
        }
        String[] token = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            token[i] = list.get(i);
        }

        return token;
    }
}
