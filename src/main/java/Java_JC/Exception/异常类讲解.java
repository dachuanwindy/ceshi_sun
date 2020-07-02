package Java_JC.Exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author sunfch
 * @version V1.0
 * https://blog.csdn.net/qq_29229567/article/details/80773970
 * @Description: Java 异常分为 两个 错误 + 异常
 * <p>
 * 异常又分为编异异常 + 运行时异常;
 * <p>
 * 编异异常: 必须在程序中进行捕获或者向上抛出;
 * 运行时异常: 这个在程序运行过程中容易出现的异常,这个只能通过人为的进行捕获,然后处理;
 * <p>
 * 如何自定义编译时异常:
 * @date 2020/7/2 19:20
 */
public class 异常类讲解 {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("编异时异常=====");

        File file = new File("");
        FileInputStream fileInputStream = new FileInputStream(file);

        //这个是运行时异常,这个异常就没有必要来捕获
        throw new MyRuntimeException("这个异常就把讯");
    }

    /**
     * @description: 注意 : 通过这个定义的异常继承了 Exception类, 这样就必须自己来捕获--->编译时异常
     * <p>
     * <p>
     * 注意: 要是通过 继承
     * @author sunfch
     * @date 2020/7/2 19:23
     */
    public static void method() throws MyException {
        throw new MyException();
    }
}

//定义一个异常,这个异常是必须要捕获的.
class MyException extends Exception {

}

// 定义的这个异常就不需要自己来捕获
class MyRuntimeException extends RuntimeException {
    private String msg;

    MyRuntimeException(String msg) {
        super();
        this.msg = msg;
    }

}