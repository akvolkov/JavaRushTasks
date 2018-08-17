package com.javarush.task.task30.task3012;

/* 
Получи заданное число
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(74);
    }

    public void createExpression(int number) {
        //напишите тут ваш код
        int num = number, ost = 0;
        //ArrayList<Integer> arr = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;
        while (num != 0) {
            ost = num % 3;
            num = num / 3;
            if (ost == 1) {
                //то +
                //arr.add(+1);
                stringBuilder.append(" + " + (int)Math.pow(3, count));
            }
            else {
                if (ost == 2) {
                    //то результат деления увеличиваете на единицу, а в соответствующий разряд пишете -.
                    num++;
                    //arr.add(-1);
                    stringBuilder.append(" - " + (int)Math.pow(3, count));
                }
                else {
                    //0
                    //arr.add(0);
                }
            }
            count++;
        }
        System.out.println(number + " =" + stringBuilder.toString());
    }
}