package com.NIO.NIO_Linlinfeng.Nio_server;

/**
 * @author sunfch
 * @create 2018-06-03 16:04
 * @desc 服务端实现
 **/
public class Nio_server {

    private static int DEFAULT_PORT = 12345;

    private static ServerHandle serverHandle;

    public static void start(String s) {

        start(DEFAULT_PORT);
    }


    public static synchronized void start(int port) {
        if (serverHandle != null)
            serverHandle.stop();
        serverHandle = new ServerHandle(port);
        new Thread(serverHandle, "Server").start();
    }

    public static void main(String[] args) {
        start(12345);
    }
}
