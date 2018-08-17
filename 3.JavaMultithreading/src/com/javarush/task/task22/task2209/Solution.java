package com.javarush.task.task22.task2209;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //...
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();
        StringBuilder builder = new StringBuilder();
        while (fileReader.ready()) builder.append(fileReader.readLine());
        fileReader.close();
        StringBuilder result = getLine(builder.toString().split(" "));
        System.out.println(result.toString());
    }
    public static StringBuilder getLine(String... words) {
        StringBuilder builder = new StringBuilder();
        if (words == null || words.length == 0) return builder;
        ArrayList<String> list = new ArrayList<>(words.length);
        list.addAll(Arrays.asList(words));
        Collections.sort(list);
        builder.append(list.get(0));
        list.remove(0);
        boolean end = true;
        while (end) {
            end = false;
            for (int i = 0; i < list.size(); i++) {
                char first = Character.toLowerCase(builder.charAt(0));
                char last = Character.toLowerCase(builder.charAt(builder.length() - 1));
                String word = list.get(i);
                if (word.toLowerCase().charAt(0) == last) {
                    builder.append(" ").append(word);
                    list.remove(i);
                    end = true;
                    break;
                }
                if (word.charAt(word.length() - 1) == first) {
                    builder.insert(0, " ").insert(0, word);
                    list.remove(i);
                    end = true;
                    break;
                }
            }
        }
        return builder;
    }
}