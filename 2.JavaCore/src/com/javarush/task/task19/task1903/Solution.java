package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();
    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }
    public static void main(String[] args) {
        int phoneNumber = 501234567;
        String line = String.format("%010d", phoneNumber);
        line = "(" + line.substring(0, 3) + ")"
                + line.substring(3 , 6) + "-"
                + line.substring(6, 8) + "-"
                + line.substring(8);
        System.out.println(line);
    }

    public static class IncomeDataAdapter implements Customer, Contact{
        private IncomeData data;
        IncomeDataAdapter (IncomeData data) {
            this.data = data;
        }

        @Override
        public String getCompanyName() {
            return this.data.getCompany();
        }

        @Override
        public String getCountryName() {
                            return countries.get(this.data.getCountryCode());


        }

        @Override
        public String getName() {
            return this.data.getContactLastName() + ", " + this.data.getContactFirstName();
        }

        @Override
        public String getPhoneNumber() {
            int phoneNumber = this.data.getPhoneNumber();
            String line = String.format("%010d", phoneNumber);
            line = "(" + line.substring(0, 3) + ")"
                        + line.substring(3 , 6) + "-"
                            + line.substring(6, 8) + "-"
                                + line.substring(8);
            return "+" + this.data.getCountryPhoneCode() + line;
            }
        }



    public static interface IncomeData {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        int getCountryPhoneCode();      //example 38

        int getPhoneNumber();           //example 501234567
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