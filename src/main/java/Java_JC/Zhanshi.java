package Java_JC;


import java.util.Collection;
import java.util.Collections;
import java.util.Hashtable;

class Dianqi {

    public void monitor() {
        System.out.println("监控");
    }

    public void display() {
        System.out.println("显示");
    }
}

class dianshi extends Dianqi {

    public void monitor() {
        System.out.println("电视机---监控");
    }

    public void display() {
        System.out.println("电视机--显示");
    }

}

class dianna extends Dianqi {

    public void monitor() {
        System.out.println("diannap monitor ");
    }

    public void display() {

        System.out.println("diannao zhanshi ");
    }

}


public class Zhanshi {

    public static void main(String[] args) {

        System.out.println("向上转型");

        Person sunfff = new Person();
        sunfff.chifanga();


        button kaishi = new button();
        kaishi.doubcilk();

        int aa = kaishi.yunsuan(10, 20);

        System.out.println(aa);


    }

}


class Person {


    public String name;

    public String xingmbie;

    public void chifanga() {

        System.out.println("吃饭");
    }


}

class button {

    public void doubcilk() {


        System.out.println("双击输出");
    }

    public void click() {


    }


    public void yanshe() {


    }

    public int yunsuan(int a, int b) {


        return a + b;

    }

}