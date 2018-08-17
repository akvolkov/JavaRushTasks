package com.javarush.task.task17.task1720;

public class Bankomat {

    static volatile BankAccount account = new BankAccount("Amigo"); // создаем аккаунт

    public static volatile boolean isStopped;

    public static void main(String[] args) throws InterruptedException {
        addMoney.start(); //запускаем нить, через секунду кладем 1000
        SpendThread spendThread = new SpendThread(); // создаем нить
        SpendThread spendThread1 = new SpendThread(); // создаем нить
        SpendThread spendThread2 = new SpendThread(); // создаем нить
        spendThread.start();//запускаем нить
        spendThread1.start();//запускаем нить
        spendThread2.start();//запускаем нить
        Thread.sleep(4000);// спим 4 секунды
        isStopped = true; //
    }

    private static Thread addMoney = new Thread() {
        @Override
        public void run() {
            while (!isStopped) {
                account.deposit("1000");            //кладем на счет
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    };


    public static class SpendThread extends Thread {

        @Override
        public void run() {
            while (!isStopped) {
                try {
                    account.withdraw("100");             //снимаем со счета
                } catch (NotEnoughMoneyException e) {
                    System.out.println("Недостаточно денег");
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }
}
