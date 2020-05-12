package inspur.BXD_JCSP.Bixiangdong_study_string.String_study;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * JDK 升级的三个因素：1.提高效率， 2 提高安全性  3 简化书写
 * <p>
 * <p>
 * stringbuffer: 线程是安全的 但是效率地下
 * stringbuilder ： 线程不安全，但是效率高 ，建议平常使用 第二个;
 * <p>
 * 容器:增删改查····
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 基本数据类型: 基本数据类型包装类
 * boolean : Boolean
 * byte ：Byte
 * char ：charsert
 * int  Interger
 * long : Long
 * float :Float
 * double Double
 * <p>
 * 基本数据类型出现的作用：就是String 与基本数据类型之间转换
 * <p>
 * <p>
 * <p>
 * 知识点： 迭代器Iterator 与  ListIterator
 * ListIterator 指在遍历中可以对集合进行增删改查，（知识点要get到）
 * <p>
 * 第二大块：集合 集合中存放都是地址：
 * List
 * |--Arrylist： 用数组的形式去存储数据，修改数据，查询数据比较快 : 线程是不安全的
 * |--Linkedlist  用链表数据结构去存储数据，存储的是链表地址， 增加比较快，但是修改和删除比较慢： linkedlinst: 常用方法有
 * --------------1.pollfirst()  2.pushfirst(); 【可以模拟一个堆栈和队列】
 * |victor： 线程是同步的，线程安全，也是用数组去存储数据的。   枚举是vector 特有的取出数据的方式。
 * set
 * |--hashset：
 * |--treeset
 * <p>
 * Map
 * |--hashMap
 * |--
 */
public class Testmain {
    public static void main(String[] a) {
        System.out.println("ssssss；");
        stringbuffer s = new stringbuffer();
        s.stringbuffe1();
    }
}

class stringbuffer {
    public void stringbuffe1() {
        StringBuffer stb = new StringBuffer();
        stb.append("sunfengchuan；").append("1111");
        System.out.println(stb.toString());


        List list = new ArrayList();
        Iterator it = list.iterator();
        Iterator it2 = list.listIterator();
    }
}