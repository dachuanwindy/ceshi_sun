package com.XLH_2;

import java.io.*;

/**
 * Title:应用学生类
 * Description:实现学生类实例的序列化与反序列化
 * Copyright: copyright(c) 2012
 * Filename: UseStudent.java
 *
 * @author Wang Luqing
 * @version 1.0
 */

public class UseStudent {

    public static void main(String[] args) {
        //   File file = new File("student.txt");
        Student st = new Student("Tom", 10, 'f');

//        try {
//            file.createNewFile();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        try {
            //Student对象序列化过程
            FileOutputStream fos = new FileOutputStream(new File("1"));
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(st);
            oos.flush();
            oos.close();
            fos.close();

            //Student对象反序列化过程
            FileInputStream fis = new FileInputStream(new File("1"));
            ObjectInputStream ois = new ObjectInputStream(fis);
            Student st1 = (Student) ois.readObject();
            System.out.println("name = " + st1.getName());
            System.out.println("sex = " + st1.getSex());

            ois.close();
            fis.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}