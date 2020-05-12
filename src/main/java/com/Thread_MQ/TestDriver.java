/*package com.Thread_MQ;

public class TestDriver {

    Threadpool_manager threadpool_manager = new Threadpool_manager.newInstance();

    public static void main(String[] args) {

        for (int i = 0; i < 1000; i++) {
            new TestDriver().sendMsg(Integer.toString(i));
        }

        //new TestDriver().sendMsg("发起一条对象" );
    }

    public void sendMsg(String msg) {

        threadpool_manager.addLogMsg(msg + "记录一条日志 ");
    }
} */