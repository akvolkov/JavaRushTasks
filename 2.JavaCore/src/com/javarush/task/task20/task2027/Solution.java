package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };

        List <Word> list = new ArrayList<Word>();
        list = detectAllWords(crossword, "home", "same", "oe");
        System.out.println("list length = " + list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }

        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        ArrayList<Word> list = new ArrayList<Word>();
        for (int word = 0; word < words.length; word++ ) {
            char[] wordToCharArray = words[word].toCharArray();
            //System.out.println(words[word]);
            for (int i = 0; i < crossword.length; i++) {
                for (int j = 0; j < crossword[i].length; j++) {
                    if (wordToCharArray[0] == crossword[i][j]) {
                        //System.out.println(i + " " + j);
                        Word northWord = northMethod (crossword, wordToCharArray, i, j);
                        if (northWord != null) {
                            list.add(northWord);
                            //System.out.println("northMethod start");
                            //System.out.println();
                        }
                        Word southWord = southMethod (crossword, wordToCharArray, i, j);
                        if (southWord != null) {
                            list.add(southWord);
                            //System.out.println("southMethod start");
                            //System.out.println();
                        }
                        Word eastWord = eastMethod (crossword, wordToCharArray, i, j);
                        if (eastWord != null) {
                            list.add(eastWord);
                            //System.out.println("eastMethod start");
                            //System.out.println();
                        }
                        Word westWord = westMethod (crossword, wordToCharArray, i, j);
                        if (westWord != null) {
                            list.add(westWord);
                            //System.out.println("westMethod start");
                            //System.out.println();
                        }
                        Word northEastWord = northEastMethod (crossword, wordToCharArray, i, j);
                        if (northEastWord != null) {
                            list.add(northEastWord);
                            //System.out.println("northEastMethod start");
                            //System.out.println();
                        }
                        Word southEastWord = southEastMethod (crossword, wordToCharArray, i, j);
                        if (southEastWord != null) {
                            list.add(southEastWord);
                            //System.out.println("southEastMethod start");
                            //System.out.println();
                        }
                        Word southWestWord = southWestMethod (crossword, wordToCharArray, i, j);
                        if (southWestWord != null) {
                            list.add(southWestWord);
                            //System.out.println("southWestMethod start");
                            //System.out.println();
                        }
                        Word northWestWord = northWestMethod (crossword, wordToCharArray, i, j);
                        if (northWestWord != null) {
                            list.add(northWestWord);
                            //System.out.println("northWestMethod start");
                            //System.out.println();
                        }
                    }
                }
            }
        }
        return list;
    }

    public static Word northWestMethod (int [][] crossword, char[] wordToCharArray, int i, int j) {
        int startX = i;
        int startY = j;
        int count = 0;
        Boolean flag = false;
        String text = "";
        if (((startX - wordToCharArray.length) >= -1) && ((startY - wordToCharArray.length) >= -1)) {
            while (count < wordToCharArray.length) {
                //System.out.println(count);
                text += wordToCharArray[count];
                if (wordToCharArray[count] == crossword[startX][startY]) {
                    flag = true;
                    count++;
                    startY--;
                    startX--;
                }
                else {
                    flag = false;
                    break;
                }
            }
        }
        if (flag == true) {
            int endX = startX +1;
            int endY = startY + 1;
            Word word = new Word(text);
            word.setStartPoint(j, i);
            word.setEndPoint(endY, endX);
            return word;
        }
        else {
            return null;
        }
    }

    public static Word southWestMethod (int [][] crossword, char[] wordToCharArray, int i, int j) {
        int startX = i;
        int startY = j;
        int count = 0;
        Boolean flag = false;
        String text = "";
        if (((startX + wordToCharArray.length) <= crossword.length) && ((startY - wordToCharArray.length) >= -1)) {
            while (count < wordToCharArray.length) {
                //System.out.println(count);
                text += wordToCharArray[count];
                if (wordToCharArray[count] == crossword[startX][startY]) {
                    flag = true;
                    count++;
                    startY--;
                    startX++;
                }
                else {
                    flag = false;
                    break;
                }
            }
        }
        if (flag == true) {
            int endX = startX - 1;
            int endY = startY + 1;
            Word word = new Word(text);
            word.setStartPoint(j, i);
            word.setEndPoint(endY, endX);
            return word;
        }
        else {
            return null;
        }
    }

    public static Word southEastMethod (int [][] crossword, char[] wordToCharArray, int i, int j) {
        int startX = i;
        int startY = j;
        int count = 0;
        Boolean flag = false;
        String text = "";
        if (((startX + wordToCharArray.length) <= crossword.length) && ((startY + wordToCharArray.length) <= crossword[startX].length)) {
            while (count < wordToCharArray.length) {
                //System.out.println(count);
                text += wordToCharArray[count];
                if (wordToCharArray[count] == crossword[startX][startY]) {
                    flag = true;
                    count++;
                    startY++;
                    startX++;
                }
                else {
                    flag = false;
                    break;
                }
            }
        }
        if (flag == true) {
            int endX = startX - 1;
            int endY = startY - 1;
            Word word = new Word(text);
            word.setStartPoint(j, i);
            word.setEndPoint(endY, endX);
            return word;
        }
        else {
            return null;
        }
    }

    public static Word northEastMethod (int [][] crossword, char[] wordToCharArray, int i, int j) {
        int startX = i;
        int startY = j;
        int count = 0;
        Boolean flag = false;
        String text = "";
        if (((startY + wordToCharArray.length) <= crossword[startX].length) && ((startX - wordToCharArray.length) >= -1)) {
            while (count < wordToCharArray.length) {
                //System.out.println(count);
                text += wordToCharArray[count];
                if (wordToCharArray[count] == crossword[startX][startY]) {
                    flag = true;
                    count++;
                    startY++;
                    startX--;
                }
                else {
                    flag = false;
                    break;
                }
            }
        }
        if (flag == true) {
            int endX = startX+1;
            int endY = startY-1;
            Word word = new Word(text);
            word.setStartPoint(j, i);
            word.setEndPoint(endY, endX);
            return word;
        }
        else {
            return null;
        }
    }

    public static Word westMethod (int [][] crossword, char[] wordToCharArray, int i, int j) {
        int startX = i;
        int startY = j;
        int count = 0;
        Boolean flag = false;
        String text = "";
        if ((startY - wordToCharArray.length >= -1) ) {
            while (count < wordToCharArray.length) {
                //System.out.println(count);
                text += wordToCharArray[count];
                if (wordToCharArray[count] == crossword[startX][startY]) {
                    flag = true;
                    count++;
                    startY--;
                }
                else {
                    flag = false;
                    break;
                }
            }
        }
        if (flag == true) {
            int endX = startX;
            int endY = startY + 1;
            Word word = new Word(text);
            word.setStartPoint(j, i);
            word.setEndPoint(endY, endX);
            return word;
        }
        else {
            return null;
        }
    }

    public static Word eastMethod (int [][] crossword, char[] wordToCharArray, int i, int j) {
        int startX = i;
        int startY = j;
        int count = 0;
        Boolean flag = false;
        String text = "";
        if ((startY + wordToCharArray.length <= crossword.length) ) {
            while (count < wordToCharArray.length) {
                //System.out.println(count);
                text += wordToCharArray[count];
                if (wordToCharArray[count] == crossword[startX][startY]) {
                    flag = true;
                    count++;
                    startY++;
                }
                else {
                    flag = false;
                    break;
                }
            }
        }
        if (flag == true) {
            int endX = startX;
            int endY = startY - 1;
            Word word = new Word(text);
            word.setStartPoint(j, i);
            word.setEndPoint(endY, endX);
            return word;
        }
        else {
            return null;
        }
    }

    public static Word southMethod (int [][] crossword, char[] wordToCharArray, int i, int j) {
        int startX = i;
        int startY = j;
        int count = 0;
        Boolean flag = false;
        String text = "";
        if ((startX + wordToCharArray.length <= crossword.length) ) {
            while (count < wordToCharArray.length) {
                //System.out.println(count);
                text += wordToCharArray[count];
                if (wordToCharArray[count] == crossword[startX][startY]) {
                    flag = true;
                    count++;
                    startX++;
                }
                else {
                    flag = false;
                    break;
                }
            }
        }
        if (flag == true) {
            int endX = startX - 1;
            int endY = startY;
            Word word = new Word(text);
            word.setStartPoint(j, i);
            word.setEndPoint(endY, endX);
            return word;
        }
        else {
            return null;
        }
    }

    public static Word northMethod (int [][] crossword, char[] wordToCharArray, int i, int j) {
        int startX = i;
        int startY = j;
        int count = 0;
        Boolean flag = false;
        String text = "";
        if ((startX - wordToCharArray.length >= -1) ) {
            while (count < wordToCharArray.length) {
                //System.out.println(count);
                text += wordToCharArray[count];
                if (wordToCharArray[count] == crossword[startX][startY]) {
                    flag = true;
                    count++;
                    startX--;
                }
                else {
                    flag = false;
                    break;
                }
            }
        }
        if (flag == true) {
            int endX = startX + 1;
            int endY = startY;
            Word word = new Word(text);
            word.setStartPoint(j, i);
            word.setEndPoint(endY, endX);
            return word;
        }
        else {
            return null;
        }
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
