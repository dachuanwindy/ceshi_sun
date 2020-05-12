package com.XLH_2;

import java.io.Serializable;

public class Student implements Serializable {

    private String name;
    private int age;
    private char sex;


    public Student() {
    }

    public Student(String name, int age, char sex) {

        this.age = age;
        this.name = name;
        this.sex = sex;
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

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }


}
