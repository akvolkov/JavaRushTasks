package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner{
        private final Scanner fileScanner;
        PersonScannerAdapter (Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }


        @Override
        public Person read() throws IOException {
            String s = this.fileScanner.nextLine();
            String firstName = null;
            String middleName = null;
            String lastName = null;
            Date birthDate = null;
            s = s.trim();
            String[] words = s.split(" ");
            lastName = words[0];
            firstName = words[1];
            middleName = words[2];
            String date = words[3] + "." + words[4] + "." + words[5];
            birthDate = new Date(date);
            Person person = new Person(firstName, middleName, lastName, birthDate);
            return person;
        }

        @Override
        public void close() throws IOException {
            this.fileScanner.close();
        }
    }
}
