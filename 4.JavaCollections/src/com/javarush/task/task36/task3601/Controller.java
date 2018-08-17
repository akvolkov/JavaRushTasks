package com.javarush.task.task36.task3601;

import java.util.List;

/**
 * Created by Home PC Volkov on 17.07.2018.
 */
public class Controller {
    public List<String> onDataListShow() {
        return new Model().getStringDataList();
    }
}
