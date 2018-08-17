package com.javarush.task.task27.task2712.statistic.event;

import com.javarush.task.task27.task2712.ad.Advertisement;

import java.util.Date;
import java.util.List;

/**
 * Created by Home PC Volkov on 11.03.2018.
 */
public class VideoSelectedEventDataRow implements EventDataRow {
    private List<Advertisement> optimalVideoSet; //список видео-роликов, отобранных для показа
    private long amount; // сумма денег в копейках
    private int totalDuration; //общая продолжительность показа отобранных рекламных роликов
    private Date currentDate;

    public VideoSelectedEventDataRow(List<Advertisement> optimalVideoSet, long amount, int totalDuration) {
        this.optimalVideoSet = optimalVideoSet;
        this.amount = amount;
        this.totalDuration = totalDuration;
        this.currentDate = new Date();
    }

    public List<Advertisement> getOptimalVideoSet() {
        return optimalVideoSet;
    }

    public long getAmount() {
        return amount;
    }

    public int getTotalDuration() {
        return totalDuration;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public EventType getType() {
        return EventType.SELECTED_VIDEOS;
    }

    @Override
    public Date getDate() {
        return currentDate;
    }

    @Override
    public int getTime() {
        return totalDuration;
    }
}
