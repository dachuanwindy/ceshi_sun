package com.Vector_learning;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Vector_ceshi {

    public static void main(String[] args) {
        Vector vector = new Vector();
        vector.add("1");
        vector.add("2");
        vector.add("3");
        vector.add("4");
        vector.add("4");
        vector.add("5");

        System.out.println(vector.get(1));
        System.out.println(vector.get(0));
        vector.set(1, "sunfeng");


        System.out.println(vector.get(1));


        Object dfd = vector.lastElement();

        int dfdf = vector.capacity();
        System.out.println(dfd.toString());


        //泛型
        List list = new ArrayList();

        list.add("1000");
        list.add(100);


    }

}
