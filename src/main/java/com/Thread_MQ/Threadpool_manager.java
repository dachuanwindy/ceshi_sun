/*package com.thread_mq;

import com.thread_mq.accessdbthread;

import java.util.linkedlist;
import java.util.queue;
import java.util.concurrent.*;

public class threadpool_manager {

    // 线程池维护线程的最少数量
    private final static int core_pool_size = 4;
    // 线程池维护线程的最大数量
    private final static int max_pool_size = 10;
    // 线程池维护线程所允许的空闲时间
    private final static int keep_alive_time = 0;
    // 线程池所使用的缓冲队列大小
    private final static int work_queue_size = 10;
    private static threadpool_manager tpm = new threadpool_manager();
    @suppresswarnings({"rawtypes", "unchecked"})
    final threadpoolexecutor threadpool = new threadpoolexecutor(
            core_pool_size, max_pool_size, keep_alive_time,
            timeunit.seconds, new arrayblockingqueue(work_queue_size), this.handler);
    // 调度线程池
    final scheduledexecutorservice scheduler = executors.newscheduledthreadpool(100);
    @suppresswarnings("rawtypes")
    final scheduledfuture taskhandler = scheduler.scheduleatfixedrate(accessbufferthread, 0, 1, timeunit.seconds);

    // 管理数据库访问的线程池
    // 消息缓冲队列
    queue<string> msgqueue = new linkedlist<string>();
    // 访问消息缓存的调度线程
    // 查看是否有待定请求，如果有，则创建一个新的accessdbthread，并添加到线程池中
    final runnable accessbufferthread = new runnable() {

        @override
        public void run() {
            if (hasmoreacquire()) {
                string msg = (string) msgqueue.poll();
                runnable task = new accessdbthread(msg);
                threadpool.execute(task);
            }
        }
    };
    final rejectedexecutionhandler handler = new rejectedexecutionhandler() {

        @override
        public void rejectedexecution(runnable r, threadpoolexecutor executor) {
            system.out.println(((accessdbthread) r).getmsg() + "消息放入队列中重新等待执行");
            msgqueue.offer(((accessdbthread) r).getmsg());
        }
    };

    private threadpool_manager() {
    }

    public static threadpool_manager newinstance() {

        return tpm;
    }

    private boolean hasmoreacquire() {
        return !msgqueue.isempty();
    }

    public void addlogmsg(string msg) {
        runnable task = new accessdbthread(msg);
        threadpool.execute(task);
    }

    public static class newinstance extends threadpool_manager {
    }
}*/