package com.javarush.task.task17.task1711;

import com.javarush.task.task17.task1710.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    creations(args);
                    break;
                }
            case "-u":
                synchronized (allPeople) {
                    updates(args);
                    break;
                }
            case "-d":
                synchronized (allPeople) {
                    deletion(args);
                    break;
                }
            case "-i":
                synchronized (allPeople) {
                    info(args);
                    break;
                }
        }
    }
    private static void creations(String[] a) throws ParseException {
        for (int i = 3; i < (a.length);i +=3 ) {
            if (a[i-1].equals("м")) {
                String dateStr = a[i];
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                Date d = format.parse(dateStr);
                allPeople.add(Person.createMale(a[i-2], d));
                System.out.println(allPeople.size()-1);
            }
            if (a[i-1].equals("ж")) {
                String dateStr = a[i];
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                Date d = format.parse(dateStr);
                allPeople.add(Person.createFemale(a[i-2], d));
                System.out.println(allPeople.size()-1);
            }
        }
        /*for (Person peaple:allPeople
             ) {
            System.out.println(peaple.getName() + " " + peaple.getSex() + " " + peaple.getBirthDay());
        }*/
    }
    private static void updates (String[] a) throws ParseException {
        for (int i = 4; i < a.length; i += 4) {
            int id = Integer.parseInt(a[i-3]);
            allPeople.get(id).setName(a[i-2]);
            Sex usex = null;
            if (a[i-1].equals("м")) {
                usex = Sex.MALE;
            }
            if (a[i-1].equals("ж")) {
                usex = Sex.FEMALE;
            }
            allPeople.get(id).setSex(usex);
            String dateStr = a[i];
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            Date d = format.parse(dateStr);
            allPeople.get(id).setBirthDay(d);
        }
       /* for (Person peaple:allPeople
                ) {
            System.out.println(peaple.getName() + " " + peaple.getSex() + " " + peaple.getBirthDay());
        }*/
    }
    private static void deletion (String[] a) {
        int id;
        for (int i = 1; i < a.length; i++) {
            id = Integer.parseInt(a[i]);
            allPeople.get(id).setName(null);
            allPeople.get(id).setBirthDay(null);
            allPeople.get(id).setSex(null);
        }
       /* for (Person peaple:allPeople
                ) {
            System.out.println(peaple.getName() + " " + peaple.getSex() + " " + peaple.getBirthDay());
        }*/
    }
    private static void info (String[] a) {
        int id;
        for (int i = 1; i < a.length; i++) {
            id = Integer.parseInt(a[i]);
            String str = allPeople.get(id).getName();
            //преобразование пола в строку
            String imale=null;
            if (allPeople.get(id).getSex()==Sex.MALE) {
                //System.out.println("1");
                imale = "м";
            }
            else imale = "ж";
            str = str + " " + imale;
            // преобразование даты в строку для склейки
            SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            Date datef = allPeople.get(id).getBirthDay();
            str = str + " " + dateformat.format(datef);
            System.out.println(str);
        }
    }
}
