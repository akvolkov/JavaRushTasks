package com.javarush.task.task37.task3702.male;

import com.javarush.task.task37.task3702.AbstractFactory;
import com.javarush.task.task37.task3702.Human;
import com.javarush.task.task37.task3702.male.KidBoy;
import com.javarush.task.task37.task3702.male.Man;
import com.javarush.task.task37.task3702.male.TeenBoy;

/**
 * Created by Home PC Volkov on 12.07.2018.
 */
public class MaleFactory implements AbstractFactory{
    public Human getPerson(int age) {
        if (age <= 12) return new KidBoy();
        else {
            if (age <= 19) return new TeenBoy();
            else return new Man();
        }
    }
}
