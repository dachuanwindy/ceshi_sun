package juc_study.readwriteLock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 读写锁的特点, 如何使用
 * <p>
 * 1.读锁==共享锁==S锁
 * 写锁==排它锁==x锁;
 * 2.读锁--是支持多个线程进行读的,
 * 写锁--不支持多读 多写的的,
 * 3. 读 读不互斥;
 * 读写 互斥 ;
 * 写读 互斥;
 * @date 2020/6/15 06:22
 */
public class ReadWriteLock {

    public static void main(String[] args) {

        MyCache myCache = new MyCache();
        for (int i = 0; i < 5; i++) {
            final int temp = i;
            new Thread(() -> {
                myCache.put(temp + "", temp + "");
            }).start();
        }

        for (int i = 0; i < 5; i++) {
            final int temp = i;
            new Thread(() -> {
                myCache.get(temp + "");
            }).start();
        }
    }
}

class MyCache {
    private Map<String, Object> cache = new HashMap<>();
    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
    private ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();

    /**
     * @description: 写锁
     * @author sunfch
     * @date 2020/6/15 06:26
     */
    public void put(String key, Object value) {

        try {
            writeLock.lock();
            System.out.println("当前值写入成功-->key==" + key);
            cache.put(key, value);
            System.out.println("当前值写入成功-->key==" + key);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }

    }

    /**
     * @description: 写入
     * @author sunfch
     * @date 2020/6/15 06:28
     */
    public void get(String key) {
        try {
            readLock.lock();
            System.out.println("读--成功-->key==" + key);
            cache.get(key);
            System.out.println("读--成功-->key==" + key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
        }
    }
}
