package com.Tree_study.HashTable;

import java.util.Hashtable;

public class HashTable {
    //存放info对象的一个数组。  理解： 一般情况下是 int [], 是存放int 类型的数据。

    private Info arr[];

    public HashTable() {
        arr = new Info[100];
    }

    public HashTable(int max) {
        arr = new Info[max];
    }

    //插入数据
    public void Insert(Info info) {
        arr[info.getKey()] = info;

    }

    //查找数据
    public Info Find(int key) {
        return arr[key];
    }
}


class Testmain {
    static {
        System.out.println("shuchusufengchuan1111111111");
    }
    public static void main(String[] s) {
        System.out.println("Hashtable 测试学习");
/*
        HashTable hs = new HashTable();
        hs.Insert(new Info(12, "sfc1"));
        hs.Insert(new Info(13, "sfc2"));
        hs.Insert(new Info(15, "sfc3"));
        Info info = hs.Find(12);
        System.out.println(info.getName());
*/




        Hashtable hashtable = new Hashtable();
        hashtable.put("zhangsan", "sunfengchuan");
        hashtable.put("zhangsan", "sunfengchuan1");

        System.out.println(hashtable.get("zhangsan"));


    }


}

class person {
    public int key;

    public String name;

}