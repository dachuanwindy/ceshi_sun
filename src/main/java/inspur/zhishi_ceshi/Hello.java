package inspur.zhishi_ceshi;

/**
 * this 关键字用法：1指当前类中的一些方法 this.name =name ;或者this.hello =形式参数；
 * 2. 构造方法的作用：有利于类的初始化工作
 * 构造方法的特点：与类名相同，可以没有返回值，可以有各种参数，只要和类名相同即可
 */

public class Hello {

    String s = "hello world";

    public Hello() {
        System.out.println("此方法为构造方法");

    }

    public Hello(String s) {

        this.s = s;
        this.ceshi();
        System.out.println(this.s);
    }

    public static void main(String[] args) {

        Hello hello = new Hello("ssfefdfd");

        System.out.println("dayinchenggon ");
    }

    public void ceshi() {
        System.out.println("测试成绩");

    }
}
