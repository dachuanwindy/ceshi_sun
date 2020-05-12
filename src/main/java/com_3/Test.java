package com_3;

public class Test {

    private int abc = 123;

    static int ccc = 1233;

    volatile int aa = 555;

    public static void main(String[] args) {
        synchronized (Test.class) {
            synchronized (new Test()) {
                ccc = 999;
                System.out.println(ccc);
            }
        }
        System.out.println(ccc);
    }

    public void test2() {
        aa = 123444;
    }
}
