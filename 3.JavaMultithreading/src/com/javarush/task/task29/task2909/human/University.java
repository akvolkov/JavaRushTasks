package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {
    private List<Student> students = new ArrayList<>();
    String name;
    int age;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        //TODO:
        for (Student stud: students
             ) {
            if (stud.getAverageGrade() == averageGrade) {
                return stud;
            }
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        //TODO:
        Student max = students.get(0);
        for (Student stud: students
                ) {
            if (stud.getAverageGrade() >= max.getAverageGrade()) {
                max = stud;
            }
        }
        return max;
    }

    public Student getStudentWithMinAverageGrade() {
        Student min = students.get(0);
        for (Student stud: students
                ) {
            if (stud.getAverageGrade() < min.getAverageGrade()) {
                min = stud;
            }
        }
        return min;
    }

    public void expel(Student student) {
        int i = students.indexOf(student);
        students.remove(i);
    }

    //public void getStudentWithMinAverageGradeAndExpel() {
     //   //TODO:
   // }
}