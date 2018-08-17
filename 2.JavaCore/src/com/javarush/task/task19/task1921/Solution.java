package com.javarush.task.task19.task1921;

import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        BufferedReader brf = new BufferedReader(new FileReader(args[0]));
        String line = "";
        while ((line = brf.readLine()) != null) {
            String[] words = line.split(" ");
            //for (int i = 0; i < words.length; i++) {
            //    System.out.println(words[i]);
            //}
            String name = "";
            int year = 0;
            int month = 0;
            int day = 0;
            for (int i = words.length-1; i >= 0; i--) {
                //System.out.println(words[i]);
                if (i == words.length-1) {
                    year = Integer.parseInt(words[i]);
                    //System.out.println(year);
                }
                else {
                    if (i == words.length-2) {
                        month = Integer.parseInt(words[i])-1;
                        //System.out.println(month);
                    }
                    else {
                        if (i == words.length-3) {
                            day = Integer.parseInt(words[i]);
                            //System.out.println(day);
                        }
                        else {
                            name = words[i] + " " + name;
                            //System.out.println(name);
                        }
                    }
                }
                //System.out.println(name);
            }
            System.out.println(year);
            Date birthday = new Date();
            birthday.setYear(year-1900);
            birthday.setMonth(month);
            birthday.setDate(day);
            PEOPLE.add(new Person(name.substring(0, name.length()-1), birthday));
        }
        brf.close();
        for (int i = 0; i < PEOPLE.size(); i++) {
            System.out.println(PEOPLE.get(i).getName() + " " + PEOPLE.get(i).getBirthday());
        }

    }
}
