package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        Map <String, String> param = new HashMap<>();
        param.put("name", "Ivanov");
        param.put("country", "Ukraine");
        param.put("city", "Kiev");
        param.put("age", null);
        System.out.println(getQuery(param));
    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry entry : params.entrySet()) {
            if (entry.getValue() != null) {
                if (stringBuilder.toString().equals(""))
                    stringBuilder.append(entry.getKey()).append(" = '").append(entry.getValue()).append("'");
                else
                    stringBuilder.append(" and ").append(entry.getKey()).append(" = '").append(entry.getValue()).append("'");
            }

        }
        return stringBuilder.toString();



        /*StringBuilder stringBuilder = new StringBuilder("");
        for (Map.Entry<String,String> pair: params.entrySet()
             ) {
            String key = pair.getKey();
            String value = pair.getValue();
            if (value != null) {
                stringBuilder.append(key + " = '" + value + "' and ");
            }
        }
        stringBuilder.delete(stringBuilder.toString().length()-5, stringBuilder.toString().length());
        return stringBuilder.toString();*/
    }
}
