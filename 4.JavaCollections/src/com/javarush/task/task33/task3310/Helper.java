package com.javarush.task.task33.task3310;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Created by Home PC Volkov on 03.08.2018.
 */
public class Helper {
    public static String generateRandomString(){
        String string = "";
        SecureRandom secureRandom = new SecureRandom();
        BigInteger bigInteger = new BigInteger(130, secureRandom);
        string = bigInteger.toString(36);
        return string;
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }
}
