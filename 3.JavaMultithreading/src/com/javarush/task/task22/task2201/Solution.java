package com.javarush.task.task22.task2201;

/* 
Строки нитей или строковые нити? Вот в чем вопрос
*/
public class Solution {
    public static void main(String[] args) {
        new Solution();
    }

    public static final String FIRST_THREAD_NAME = "1#"; // имя первой нити - 1#
    public static final String SECOND_THREAD_NAME = "2#"; // имя второй нити - 2#

    private Thread thread1; // объявление нити 1
    private Thread thread2;// объявление нити 2
    private Thread thread3;// объявление нити3

    public Solution() {
        initThreads();
    } //конструктор, запускает метод initThreads()

    protected void initThreads() { // метод initThreads() инициация тредов
        //инициируем тред1 у объекта Solution, передаем конструктору new Task(this, "A\tB\tC\tD\tE\tF\tG\tH\tI") и имя
        this.thread1 = new Thread(new Task(this, "A\tB\tC\tD\tE\tF\tG\tH\tI"), FIRST_THREAD_NAME);
        this.thread2 = new Thread(new Task(this, "J\tK\tL\tM\tN\tO\tP\tQ\tR\tS\tT\tU\tV\tW\tX\tY\tZ"), SECOND_THREAD_NAME);
        this.thread3 = new Thread(new Task(this, "\t\t"), "3#");

        Thread.setDefaultUncaughtExceptionHandler(new ThisUncaughtExceptionHandler());

        this.thread1.start();
        this.thread2.start();
        this.thread3.start();
    }

    public synchronized String getPartOfString(String string, String threadName) {
        try {
            int indexStart = string.indexOf('\t');
            int indexEnd = string.lastIndexOf('\t');
            String str = string.substring(indexStart + 1, indexEnd);
            return str;
        }
        catch (Exception e){
            if (threadName.equals(FIRST_THREAD_NAME)) {
                throw new TooShortStringFirstThreadException();
            }
            else {
                if (threadName.equals(SECOND_THREAD_NAME)) {
                    throw new TooShortStringSecondThreadException();
                }
                else {
                    throw new RuntimeException();
                }
            }

        }

    }
}
