package com.javarush.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;

/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String,String> countries = new HashMap<String,String>();
    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {
        String s = "+38(050)123-45-67";
        s = s.trim();
        s = s.replaceAll("[()-]", "");
       // s= s.replace(")", "");
        //s =s.replace("-", "");
        s = "callto://" + s;
        System.out.println(s);

    }

    public static class DataAdapter implements RowItem{
        private Customer customer;
        private Contact contact;
        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        @Override
        public String getCountryCode() {
            String s = this.customer.getCountryName();
            String code = null;
            for (Map.Entry<String, String> pair:countries.entrySet()
                 ) {
                String key = pair.getKey();
                String value = pair.getValue();
                if (s.equals(value)) {
                    code = key;
                    break;
                }
            }
            return code;
                    //countries.get(this.customer.getCountryName());
        }

        @Override
        public String getCompany() {
            return this.customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            String s = this.contact.getName();
            s = s.trim();
            String[] array = s.split(" ");
            return array[1];
        }

        @Override
        public String getContactLastName() {
            String s = this.contact.getName();
            s = s.trim();
            String[] array = s.split(", ");
            //s = array[0].substring(0, 6);

            return array[0];
        }

        @Override
        public String getDialString() {               //example callto://+380501234567
            String s = this.contact.getPhoneNumber(); //example +38(050)123-45-67
            s = s.trim();
            s = s.replaceAll("[()-]", "");
            s = "callto://" + s;
            return s;
        }
    }

    public static interface RowItem {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        String getDialString();         //example callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.
        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan
        String getPhoneNumber();        //example +38(050)123-45-67
    }
}