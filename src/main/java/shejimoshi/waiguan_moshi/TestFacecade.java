package shejimoshi.waiguan_moshi;
/*
* 外观模式,没有用到接口 想想实现两个类之间的关联，
* 但是又不想这两个类之前的耦合关系，就建立一个类，专门来实现着两个类之间的调用。
*
* 第一步：建立两个普通的类，
*
* 第二步：新建一个类 computor，引用这两个类，然后再构造方法中进行初始化，（这样在类的方法再用的时候，就可以不初始化了）
*
* 第三步： 在computer类中 写自己的方法，直接调用这些方法就OK了，简单明了
*
*
* */
public class TestFacecade {
    public static void main(String [] args) {
        Computer computer = new Computer();
        computer.startup();
        computer.shutdown();
    }
}
