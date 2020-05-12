package shejimoshi.Observer_Mode;

import java.util.Enumeration;
import java.util.Vector;

public interface Subject {
    // 增加观察者
    public void add(Observer observer);

    //删除观察者
    public void delet(Observer observer);

    //通知观察者
    public void notify1();

    //自身操作
    public void operation();
}


abstract class abstractobject implements Subject {

    private Vector<Observer> vector = new Vector<Observer>();

    @Override
    public void add(Observer observer) {
        vector.add(observer);
    }

    @Override
    public void delet(Observer observer) {
        vector.remove(observer);

    }

    @Override
    public void notify1() {
        Enumeration<Observer> enumo = vector.elements();
        while (enumo.hasMoreElements()) {
            enumo.nextElement().update();
        }

    }

    @Override
    public void operation() {

    }
}

class Myobject extends abstractobject {
    @Override
    public void operation() {
        System.out.println("实现自身的操作");
        notify1();

    }
}