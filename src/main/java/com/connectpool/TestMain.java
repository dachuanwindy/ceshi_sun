package com.connectpool;


import redis.clients.jedis.Jedis;

import java.util.concurrent.CountDownLatch;

/**
 * @Description: //TODO 连接池测试
 * @Author: sunfch
 * @Date: 2018/12/29 10:27
 * @Param:
 * @Return:
 */
public class TestMain {

    /*线程数目*/
    private static int threadcount = 30;
    // 同事并发数据
    private final static CountDownLatch LATCH = new CountDownLatch(threadcount);

    public static void main(String[] args) {

        final Pool  pool  = new ConnectPoolImp();
        pool.init(10,2000L);

        for (int i = 0; i < threadcount; i++) {
            new  Thread(new Runnable() {
                @Override
                public void run() {
                    int i =0;
                    while (i<10){
                        i++;
                        Jedis jedis= null;
                        try {
                            LATCH.countDown();
                            LATCH.await();
                            jedis = pool.borrowResource();
                            jedis.get("sunfch");
                            System.out.println(jedis.get("sunf"));

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }finally {
                            try {
                                pool.release(jedis);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }).start();
        }
    }
}

