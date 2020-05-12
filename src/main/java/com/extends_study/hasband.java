package com.extends_study;

public class hasband extends Extends_study {

    public hasband() {
        super(12);
        System.out.println("子类构造器");
    }

    public static void main(String[] args) {

        System.out.println("测试程序");

        hasband hasband = new hasband();
        hasband.age(1);
        hasband.setAge(2);
    }

}
