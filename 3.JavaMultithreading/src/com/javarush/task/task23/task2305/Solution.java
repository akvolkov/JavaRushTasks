package com.javarush.task.task23.task2305;

/* 
Inner
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution sol1 = new Solution();
        Solution sol2 = new Solution();
        InnerClass innerClass11 = sol1.new InnerClass();
        InnerClass innerClass12 = sol1.new InnerClass();
        InnerClass innerClass21 = sol2.new InnerClass();
        InnerClass innerClass22 = sol2.new InnerClass();
        sol1.innerClasses[0] = innerClass11;
        sol1.innerClasses[1] = innerClass12;
        sol2.innerClasses[0] = innerClass21;
        sol2.innerClasses[1] = innerClass22;

        Solution[] arr = new Solution[2];
        arr[0] = sol1;
        arr[1] = sol2;

        return arr;
    }

    public static void main(String[] args) {

    }
}
