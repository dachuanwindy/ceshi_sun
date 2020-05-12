package com_2.ThreadPool_test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: //TODO 模仿线程池，实现线程
 * @Author: sunfch
 * @Date: 2019/1/6 16:29
 * @Param:
 * @Return:
 */
public class ThreadPool {

    private static int ThreadNum = 5;

    private static volatile int finished_num = 0;

    //线程任务数
    private List<Runnable> taskquene = new ArrayList<>();

    // 线程池
    private static ThreadPool threadPool;

    private ThreadPool() {
    }

    public ThreadPool(int threadNum) {
        ThreadPool.ThreadNum = threadNum;

    }

    private  class  WorkThread extends  Thread{


        Thread t = Thread.currentThread();

    }
}
