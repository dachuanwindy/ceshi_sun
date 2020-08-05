import java.util.concurrent.locks.ReentrantLock;

/**
 * @author sunfch
 * @version V1.0
 * @Description: TODO
 * @date 2020/7/28 17:14
 */
public class MyTest3 {

    public static void main(String[] args) {
        Object o = new Object();

        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();

    }
}
