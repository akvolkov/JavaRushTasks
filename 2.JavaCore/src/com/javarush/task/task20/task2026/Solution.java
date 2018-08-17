package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/
public class Solution {
    public static byte[][] massiv;
    public static void main(String[] args) {
        byte[][] a = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        int count = getRectangleCount(a);
        System.out.println("count = " + count + ". Должно быть 2");
    }

    public static int getRectangleCount(byte[][] a) {
        massiv = a;
        int count = 0;
        for (int i = 0; i < massiv.length; i++) {
            for (int j = 0; j < massiv[i].length; j++) {
                if (massiv[i][j] == 1) {
                    count++;
                    serch1(i, j);
                }
            }
        }



        return count;
    }

    public static void serch1 (int i, int j) {
        int ii = i;
        int jj = j;
        while (ii < massiv.length && massiv[ii][jj] == 1) {
            while (jj < massiv[ii].length && massiv[ii][jj] == 1) {
                massiv[ii][jj] = 0;
                jj++;
            }
            ii++;
            jj = j;
        }
    }
}
