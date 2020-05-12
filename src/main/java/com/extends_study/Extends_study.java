package com.extends_study;

public class Extends_study {
    public int age;
    public String name;
    public char sex;

    public Extends_study(int i) {

        System.out.println("父类构造器" + i);
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void age(int i) {
        this.age = i;
    }
}

