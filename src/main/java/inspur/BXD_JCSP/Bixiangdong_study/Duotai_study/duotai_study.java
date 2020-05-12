package inspur.BXD_JCSP.Bixiangdong_study.Duotai_study;

/**
 * 多态的好处：提高了代码的扩展性
 * <p>
 * 多态的体现： 父类的引用可以指向子类，这样就父类就可以代替子类了，而且是代替多个子类，哈哈
 * <p>
 * 多态的前提：之间必须有继承，要么继承 要实现
 * <p>
 * <p>
 * <p>
 * <p>
 * 转型：： 向上转型 向下转型
 * <p>
 * 向上转型： Animal animal =new  cat ();
 *
 *
 * Animal animal = new Cat();
 * animal.eat();
 * 多态的成员函数的特点：
 *  在编译的是时候，是看父类中是否包含了子类的全部函数，若没有则报错，
 *  运行的时候： 看子类的函数是否能在父类中体现，
 *
 *  简单说是： 编译看左边，运行看右边
 */
public class duotai_study {

    public static void main(String[] args) {
        System.out.println("多态的学习====");

//        Cat cat = new Cat();
//        function(cat);
        function(new Dog());

    }

    public static void function(Animal animal) {


        animal.eat();




        if (animal instanceof Dog) {

            System.out.println("判断是小狗，这样就完成了判断");
        } else {
            System.out.println("判断失败， 判断个数是有限的， 才能这样做");
        }
    }
}

/**
 * 抽象类
 */
abstract class Animal {
    abstract void eat();
}

class Dog extends Animal {
    @Override
    void eat() {
        System.out.println("小狗吃骨头");
    }

    public void kanjia() {

        System.out.println("小狗看夹");
    }
}

class Cat extends Animal {
    @Override
    void eat() {
        System.out.println("小猫吃鱼--");
    }

    public void zhuamouse() {

        System.out.println("小猫抓老鼠");
    }
}
