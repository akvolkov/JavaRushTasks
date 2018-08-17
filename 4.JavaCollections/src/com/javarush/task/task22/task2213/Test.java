package com.javarush.task.task22.task2213;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Home PC Volkov on 04.06.2018.
 */
public class Test {
    static int height = 10;
    static int width = 5;

    static int[][] matrix = new int[][] {
            {0,0,1,1,0},
            {0,0,1,1,0},
            {0,0,1,1,0},
            {0,0,1,1,0},
            {0,0,1,1,0},
            {0,0,1,1,0},
            {0,0,1,1,0},
            {0,0,1,1,0},
            {0,0,1,1,0},
            {1,1,1,1,1}
    };

    public static void main(String[] args) {
        print();
        removeFullLines();
        print();
    }

    static void print() {

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (matrix[i][j] == 0) {
                    System.out.print(".");
                }
                else {
                    System.out.print("X");
                }
            }
            System.out.println();
        }
    }
    public static void removeFullLines() {

        //Например так:
        //Создаем список для хранения линий
        //Копируем все непустые линии в список.
        //Добавляем недостающие строки в начало списка.
        //Преобразуем список обратно в матрицу
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            boolean flag = true;
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    flag = false;
                }
            }
            if (!flag) {
                list.add(matrix[i]);
            }
        }
        if (list.size() != matrix.length) {
            int lenAdd = matrix.length - list.size();
            for (int i = 0; i < lenAdd; i++) {
                list.add(0, createNullArr());
            }
        }
        matrix = (int[][]) list.toArray();

    }
    private static int[] createNullArr() {
        int[] arr = new int[width];
        for (int i = 0; i < width; i++) {
            arr[i] = 0;
        }
        return arr;
    }

}
