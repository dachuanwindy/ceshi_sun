package com.XLH_study;

public class Consunmer {

    private int bianling = 10;
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Consunmer() {

    }

    public Consunmer(String name, int age) {
        this.age = age;
        this.name = name;
    }
}
