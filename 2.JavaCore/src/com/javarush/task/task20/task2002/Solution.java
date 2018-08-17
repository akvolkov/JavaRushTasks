package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream
        // в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            your_file_name = new File("C:/tmp/1.txt");
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user = new User();
            user.setFirstName("Aleksey");
            user.setLastName("Volkov");
            Date date = new Date("7 APR 1988");
            user.setBirthDate(date);
            user.setMale(true);
            user.setCountry(User.Country.RUSSIA);
            javaRush.users.add(user);

            User user1 = new User();
            user1.setFirstName("Ludmila");
            user1.setLastName("Volkova");
            Date date1 = new Date("20 JAN 1989");
            user1.setBirthDate(date1);
            user1.setMale(false);
            user1.setCountry(User.Country.RUSSIA);
            javaRush.users.add(user1);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(javaRush.equals(loadedObject));

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter writer = new PrintWriter(outputStream);
            for (int i = 0; i < this.users.size(); i++) {
                String isListPresents = this.users != null ? "yes" : "no";
                writer.println(isListPresents);
                if (isListPresents.equals("yes")) {
                    writer.println(this.users.get(i).getFirstName());
                    writer.println(this.users.get(i).getLastName());
                    long msTime = this.users.get(i).getBirthDate().getTime();
                    writer.println(msTime);
                    writer.println(this.users.get(i).isMale());
                    writer.println(this.users.get(i).getCountry());
                    writer.flush();
                }
            }
            writer.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            while (reader.ready()) {
                String isListPresents = reader.readLine();
                if (isListPresents.equals("yes")) {
                    User user = new User();
                    user.setFirstName(reader.readLine());
                    user.setLastName(reader.readLine());
                    long msTime = Long.parseLong(reader.readLine());
                    user.setBirthDate(new Date(msTime));
                    Boolean male = Boolean.parseBoolean(reader.readLine());
                    user.setMale(male);
                    String country = reader.readLine();
                    if (country.equals("UKRAINE")) {
                        user.setCountry(User.Country.UKRAINE);
                    } else {
                        if (country.equals("RUSSIA")) {
                            user.setCountry(User.Country.RUSSIA);
                        } else {
                            user.setCountry(User.Country.OTHER);
                        }
                    }
                    this.users.add(user);
                }
            }
            for (int i = 0; i < this.users.size(); i++) {
                System.out.println(users.get(i).getFirstName() + " " + users.get(i).getLastName() + " " +
                        users.get(i).getBirthDate() + " " + users.get(i).isMale() + " " + users.get(i).getCountry());
            }
            reader.close();

        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
