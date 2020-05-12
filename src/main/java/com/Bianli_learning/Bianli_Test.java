package com.Bianli_learning;

import java.util.*;

public class Bianli_Test {


    public static void main(String[] args) {

        List l = new ArrayList();
        l.add("aa");
        l.add("bb");
        l.add("cc");
        for (Iterator iter = l.iterator(); iter.hasNext(); ) {
            String str = (String) iter.next();
            System.out.println(str);
        }
        //遍历数据，iterator 这种效率比较高，方法有：for while 判断。size 然后循环输出
//        bianli_method1();
//        bianli_map();
//        bianli_2();
        set_ceshi();


        //冒泡排序
        int[] number = {1, 2, 3, 4, 6, 9, 10, 15, 7};
        paixu_maopao();

    }


    /**
     * @param
     * @return no
     * describe:实现map 遍历，
     * @author sunfengchuan
     */
    public static void bianli_map() {

        Map map = new HashMap();
        for (int j = 0; j < 100; j++) {
            map.put(j, j * j);
        }

        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Object key = entry.getKey();
            Object val = entry.getValue();
            System.out.println("map 遍历输出为" + key + "====>" + val);
        }
    }


    public static void bianli_2() {

        Map map = new HashMap();
        for (int j = 0; j < 20; j++) {
            map.put(j, j * j);
        }

        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {

            Map.Entry entry = (Map.Entry) iterator.next();
            entry.getKey();
            entry.getValue();
            System.out.println(" 测试输出===>" + entry.getKey() + "===>>" + entry.getValue());
        }
    }

    public static void set_ceshi() {
        Set set = new HashSet();
        set.add("dfdf");
        set.add("dfdf");
        set.add("sunefgngg");
        set.add(1);
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object value = iterator.next();
            System.out.println("set 集合输出的值为：===>" + value);
        }
    }


    //排序 冒泡法

    public static void paixu_maopao() {
        int[] number = {1, 2, 3, 4, 6, 9, 10, 15, 7};
        for (int i = 0; i < number.length; i++) {
            for (int j = 0; j < number.length - 1 - i; j++) {
                if (number[j] > number[j + 1]) {
                    int temp;
                    temp = number[j + 1];
                    number[j + 1] = number[j];
                    number[j] = temp;
                }

            }
        }

        for (int i = 0; i < number.length; i++)
            System.out.println(number[i]);
    }


    /**
     * 二分法查找:
     * 利用循环原理，实现折半方式查找，但是这个有个条件是： 必须是有序数组：
     */

    public void find_key(int arr[], int key) {
        int left = 0;
        int right = arr.length - 1;

    }
}


class ceshi {
    public static void main(String[] args) {

        List<String> list = new ArrayList<String>();

        list.add("ceshi1");
        list.add("ceshi2");
        list.add("ceshi3");
        list.add("ceshi4");
        list.add("ceshi5");
        list.add("ceshi6");
        list.add(4, "sunfengchuan");
        list.add(5, "sunfengchuan");

        list.remove("ceshi6");

        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals("ceshi3")) {
                iterator.remove();
                System.out.println("删除了。。。");
            }
        }

        System.out.println(list.toString());
    }

}


