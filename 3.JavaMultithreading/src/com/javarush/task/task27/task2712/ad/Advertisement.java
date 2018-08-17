package com.javarush.task.task27.task2712.ad;

/**
 * Created by Home PC Volkov on 08.03.2018.
 */
public class Advertisement { //Рекламное объявление
    private Object content;
    private String name;
    private long initialAmount;
    private int hits;
    private int duration;
    private long amountPerOneDisplaying;

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount; //начальная сумма, стоимость рекламы в копейках
        this.hits = hits; //количество оплаченных показов
        this.duration = duration; //продолжительность в секундах
        if (hits != 0) {
            this.amountPerOneDisplaying = initialAmount / hits;
        }
    }

    public long getInitialAmount() {
        return initialAmount;
    }

    public long getAmountPerOneDisplaying() {
        return amountPerOneDisplaying;
    }

    public int getHits() {
        return hits;
    }

    public int getDuration() {

        return duration;
    }

    public String getName() {

        return name;
    }

    public void revalidate() {
        if (hits <= 0) throw new NoVideoAvailableException();
        hits--;
    }
}
