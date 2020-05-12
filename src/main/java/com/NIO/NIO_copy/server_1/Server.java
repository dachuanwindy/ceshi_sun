package com.NIO.NIO_copy.server_1;



/**
 * @author sunfch
 * @create 2018-06-03 18:24
 * @desc
 **/
public class Server {
    private static int DEFAULT_PORT = 12345;
    private static ServerHandle serverHandle;
    public static void start(){
        start(DEFAULT_PORT);
    }
    public static synchronized void start(int port){
        if(serverHandle!=null)
            serverHandle.stop();
        serverHandle = new ServerHandle(port);
        new Thread(serverHandle,"Server").start();
    }
    public static void main(String[] args){
        start();
    }
}