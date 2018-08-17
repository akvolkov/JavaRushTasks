package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        /*args[0] = "-c";
        args[1] = "Миронов Дмитрий Васильевич ";
        args[2] = "м";
        args[3] = "15/04/1990";*/
        if (args[0].equals("-c")) {
            if (args[2].equals("м")) {
                String dateStr = args[3];
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                Date d = format.parse(dateStr);
                allPeople.add(Person.createMale(args[1], d));
            }
            if (args[2].equals("ж")) {
                String dateStr = args[3];
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                Date d = format.parse(dateStr);
                allPeople.add(Person.createFemale(args[1], d));
            }
            System.out.println(allPeople.size()-1);
        //System.out.println(allPeople.get(2).getName() + " " + allPeople.get(2).getSex() + " " + allPeople.get(2).getBirthDay());
        }
        if (args[0].equals("-u")) {
            int id = Integer.parseInt(args[1]);
            //System.out.println(allPeople.get(id).getName() + " " + allPeople.get(id).getSex() + " " + allPeople.get(id).getBirthDay());
            allPeople.get(id).setName(args[2]);
            if (args[3].equals("м")||args[3].equals("ж")) {
                if (args[3].equals("м")) {
                    allPeople.get(id).setSex(Sex.MALE);
                } else {
                    allPeople.get(id).setSex(Sex.FEMALE);
                }
            }
            String dateStr = args[4];
            SimpleDateFormat udateformat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            Date dateDate = udateformat.parse(dateStr);

            //SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            //Date d = format.parse(dateStr);
            allPeople.get(id).setBirthDay(dateDate);
            //System.out.println(allPeople.get(id).getName() + " " + allPeople.get(id).getSex() + " " + allPeople.get(id).getBirthDay());
        }
        if (args[0].equals("-d")) {
            allPeople.get(Integer.parseInt(args[1])).setName(null);
            allPeople.get(Integer.parseInt(args[1])).setBirthDay(null);
            allPeople.get(Integer.parseInt(args[1])).setSex(null);
        }
        if (args[0].equals("-i")) {
            int id = Integer.parseInt(args[1]);
            String imale;
            if (allPeople.get(id).getSex()==Sex.MALE) {///неправильная строка
                imale = "м";
            }
            else {
                System.out.println(allPeople.get(id).getSex());
                imale = "ж";
            }
            SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            Date datef = allPeople.get(id).getBirthDay();

            System.out.println(allPeople.get(id).getName() + " " + imale + " " + dateformat.format(datef));
        }
    }
}
