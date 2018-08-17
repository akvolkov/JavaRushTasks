package com.javarush.task.task27.task2712.statistic.event;

import java.util.Date;

/**
 * Created by Home PC Volkov on 11.03.2018.
 */
public interface EventDataRow {
    EventType getType();
    Date getDate();
    int getTime();
}
