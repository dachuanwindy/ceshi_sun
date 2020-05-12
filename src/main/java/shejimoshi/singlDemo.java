package shejimoshi;

import java.util.Observable;

public class singlDemo {
    public static singlDemo instance = new singlDemo();

    //构造方法
    private singlDemo() {
    }

    public static singlDemo getInstance() {

        return instance;
    }


}
    class observer extends Observable{
     private  final long f= (long) 0.1;

    }

