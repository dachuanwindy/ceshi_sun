package com.Vector_learning;

import java.util.Vector;

public class VectorApp {
    public static void main(String[] args) {
        Vector v1 = new Vector();
        Integer integer1 = new Integer(1);
        //加入为字符串对象
        v1.addElement("one");
        //加入的为integer的对象
        v1.addElement(integer1);
        v1.addElement(integer1);
        v1.addElement("two");
        v1.addElement(new Integer(2));
        v1.addElement(integer1);
        v1.addElement(integer1);
        //转为字符串并打印
        System.out.println("The Vector v1 is:\n\t" + v1);
        //向指定位置插入新对象

        v1.insertElementAt("three", 2);
        v1.insertElementAt(new Float(3.9), 3);
        System.out.println("The Vector v1(used method insertElementAt()is:\n\t)" + v1);
        //将指定位置的对象设置为新的对象
        //指定位置后的对象依次往后顺延
        v1.setElementAt("four", 2);
        System.out.println("The vector v1 cused method setElmentAt()is:\n\t" + v1);
        v1.removeElement(integer1);
        //从向量对象v1中删除对象integer1
        //由于存在多个integer1,所以从头开始。
        //找删除找到的第一个integer1.

        System.out.println("The vector v1 (used method removeElememt()is");

        System.out.println();
        System.out.println();
        //使用枚举类(Enumeration)的方法取得向量对象的每个元素。
        System.out.println("The position of Object1(top-to-botton):" + v1.indexOf(integer1));
        System.out.println("The position of Object1(tottom-to-top):" + v1.lastIndexOf(integer1));
        //按不同的方向查找对象integer1所处的位置
        v1.setSize(4);
        System.out.println("The new Vector(resized the vector)is:" + v1);
        //重新设置v1的大小，多余的元素被抛弃
    }
}