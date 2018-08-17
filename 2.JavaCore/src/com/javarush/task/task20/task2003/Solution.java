package com.javarush.task.task20.task2003;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();


    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream in = new FileInputStream(fileName);
        load(in);
        reader.close();
        in.close();
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties proper = new Properties();
        for (Map.Entry <String, String> pair: properties.entrySet()
             ) {
            String key = pair.getKey();
            String value = pair.getValue();
            proper.setProperty(key, value);
        }
        proper.store(outputStream, null);
        outputStream.close();

    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод

        Properties proper = new Properties();
        proper.load(inputStream);
        Enumeration e = proper.propertyNames();
        while (e.hasMoreElements()) {
            String key = (String) e.nextElement();
            String value = (String) proper.get(key);
            properties.put(key, value);
        }
        /*for (Map.Entry <String, String> pair: properties.entrySet()
             ) {
            System.out.println(pair.getKey() + " " + pair.getValue());

        }*/
    }

    public static void main(String[] args) {

    }
}
