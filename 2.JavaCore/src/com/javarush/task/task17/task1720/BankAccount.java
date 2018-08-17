package com.javarush.task.task17.task1720;

import java.math.BigDecimal;

public class BankAccount {
    private BigDecimal balance;
    private String owner;

    public BankAccount(String owner) {
        this(BigDecimal.ZERO, owner);
    }// коструктор с владельцем,

    public BankAccount(BigDecimal balance, String owner) { //констуктор с балансом и владельцем
        this.balance = balance;
        this.owner = owner;
    }

    public synchronized void deposit(BigDecimal money) {  // метод депозит, параметр BigDecimal money
        BigDecimal newBalance = balance.add(money); // newBalance = balance + money
        System.out.println("Добавляем " + money + ", на счету " + newBalance);
        balance = newBalance; //балансу присваиваем новое значение
    }

    public synchronized void withdraw(BigDecimal money) throws NotEnoughMoneyException { //вычитание
        BigDecimal newBalance = balance.subtract(money); //newBalance = balance - money

        if (newBalance.compareTo(BigDecimal.ZERO) < 0) throw new NotEnoughMoneyException();

        balance = newBalance;
        System.out.println("Тратим " + money + ", на счету " + balance);
    }

    public void deposit(String money) {
        deposit(new BigDecimal(money));
    }

    public void withdraw(String money) throws NotEnoughMoneyException {
        withdraw(new BigDecimal(money));
    }
}
