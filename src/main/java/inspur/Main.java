package inspur;

import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author sunfch
 * @description: 基本功能测试
 * @date 2020/5/19 17:43
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {

//        HashMap<Object, Object> hashMap = new HashMap<>();
//        hashMap.put("", "");
//        testIsNotblank();


    }

    public static void testIsNotblank() {
        String str = " ";
        boolean notBlank = StringUtils.isNotBlank(str);
        boolean notEmpty = StringUtils.isNotEmpty(str);
        System.out.println(notEmpty);
        System.out.println(notBlank);

        ReentrantLock reentrantLock = new ReentrantLock(true);

        reentrantLock.lock();
        try {

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }

}
