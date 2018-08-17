package com.javarush.task.task19.task1916;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();
        BufferedReader brf1 = new BufferedReader(new FileReader(file1));
        BufferedReader brf2 = new BufferedReader(new FileReader(file2));
        ArrayList<String> list1 = createList(brf1);
        //System.out.println(list1);
        ArrayList<String> list2 = createList(brf2);
        //System.out.println(list2);
        brf1.close();
        brf2.close();
        int countList2 = 0;
        int countList1 = 0;
        try {
            for (int i = 0; i < list1.size(); i++) {
                countList1++;
                if (list1.get(i).equals(list2.get(countList2))) {
                    lines.add(new LineItem(Type.SAME, list1.get(i)));
                    countList2++;
                } else {
                    if (list1.get(i).equals(list2.get(countList2 + 1))) {
                        lines.add(new LineItem(Type.ADDED, list2.get(countList2)));
                        lines.add(new LineItem(Type.SAME, list2.get(countList2 + 1)));
                        countList2 += 2;
                    } else {
                        lines.add(new LineItem(Type.REMOVED, list1.get(i)));
                    }
                }
            }
        }
        catch (IndexOutOfBoundsException e) {
           // System.out.println("пошло что то не так" + countList1 + " " + countList2);
            lines.add(new LineItem(Type.REMOVED, list1.get(countList1-1)));
        }
        if (countList2 < list2.size()) {
            for (int i = countList2; i < list2.size(); i++) {
                lines.add(new LineItem(Type.ADDED, list2.get(i)));
            }
        }

       /* for (int i = 0; i < lines.size(); i++) {
            System.out.println(lines.get(i).type+ " " + lines.get(i).line);
        }*/



    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }

    private static ArrayList<String> createList (BufferedReader brf) throws IOException {
        ArrayList<String> list = new ArrayList<String>();
        while (brf.ready()){
            list.add(brf.readLine());
        }
        return list;
    }
}
