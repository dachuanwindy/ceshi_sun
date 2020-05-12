package com.connectpool;

import redis.clients.jedis.Jedis;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Demo class
 *
 * @author sunfch
 * @date 2018/12/28 22:43
 */
public class ConnectPoolImp implements Pool {

    /* 是否关闭 */
    AtomicBoolean isclose = new AtomicBoolean(false);

    /*队列实现存储  空闲队列*/
    LinkedBlockingDeque<Jedis> idle;

    /*繁忙的队列*/
    LinkedBlockingDeque<Jedis> busy;

    /*控制大小的连接池数量*/
    AtomicInteger activesize = new AtomicInteger(0);
    /*记录连接被创建的数量*/
    AtomicInteger createCounter = new AtomicInteger(0);

    int maxctive;

    long maxwait;

    /**
     * @param maxtive
     * @param waittime
     * @Description: //TODO 初始化对象
     * @Author: sunfch
     * @Date: 2018/12/28 22:43
     * @Param:
     * @Return:
     */
    @Override
    public void init(int maxtive, long waittime) {

        this.maxctive = maxtive;
        this.maxwait = waittime;
        idle = new LinkedBlockingDeque<Jedis>();
        busy = new LinkedBlockingDeque<Jedis>();

    }

    /**
     * @Description: //TODO 获取连接，
     * @Author: sunfch
     * @Date: 2018/12/28 22:44
     * @Param:
     * @Return:
     */
    @Override
    public Jedis borrowResource() throws Exception {

        Jedis jedis = null;
        /*获取连接的开始时间*/
        long now = System.currentTimeMillis();

        while (null == jedis) {
            /*如果队列为空，就从空闲队列中取出一个来*/
            jedis = idle.poll();

            /*把当前redis放进 busy 队列*/
            if (null != jedis) {

                //放进busy 队列中去；
                busy.offer(jedis);
                System.out.println("从空闲队列中取出一个来");
                return jedis;
            }

            /*如果当前活跃的值 小于 最大活跃数目 */
            if (activesize.get() < maxctive) {
                if (activesize.incrementAndGet() <= maxctive) {
                    jedis = new Jedis("127.0.0.1", 6379);
                    System.out.println("连接池被创建的次数==>" + createCounter.incrementAndGet());
                    busy.offer(jedis);
                    return jedis;
                } else {
                    activesize.decrementAndGet();
                }

            }
            // 如果前面两个都拿不到连接，我们就设置最大等待时间，等待别人释放连接
            try {
                jedis = idle.poll(maxwait - System.currentTimeMillis() + now, TimeUnit.MILLISECONDS);
            } catch (Exception e) {
                throw new Exception(" 等待异常；；");
            }

            if (null == jedis) {
                if ((System.currentTimeMillis() - now) >= maxwait) {
                    throw new Exception("timeout....");
                } else {
                    continue;
                }
            } else {
                busy.offer(jedis);
            }

        }
        return jedis;
    }

    /**
     * @param jedis
     * @Description: //TODO 释放连接，
     * @Author: sunfch
     * @Date: 2018/12/28 22:45
     * @Param:
     * @Return:
     */
    @Override
    public void release(Jedis jedis) throws Exception {

        if (null == jedis) {
            System.out.println("释放的jedis为空");
            return;
        }
        if (busy.remove(jedis)) {
            idle.offer(jedis);
        } else {
            activesize.decrementAndGet();
            throw new Exception("释放jedis异常");
        }
    }

    /**
     * @Description: //TODO 关闭连接
     * @Author: sunfch
     * @Date: 2018/12/28 22:45
     * @Param:
     * @Return:
     */
    @Override
    public void close() {
        if (isclose.compareAndSet(false, true)) {
            /* 定义一个队列*/
            LinkedBlockingDeque<Jedis> pool = idle;
            while (pool.isEmpty()) {
                Jedis jedis = pool.poll();
                jedis.close();
                if (pool == idle && pool.isEmpty()) {
                    pool = busy;
                }
            }
        }
    }
}
