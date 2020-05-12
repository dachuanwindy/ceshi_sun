package com.NIO.NIO_copy;

import com.NIO.NIO_copy.client.Client;
import com.NIO.NIO_copy.server_1.Server;

import java.util.Scanner;

/**
 * @author sunfch
 * @create 2018-06-03 18:30
 * @desc
 **/
public class Test {
    //测试主方法
    @SuppressWarnings("resource")
    public static void main(String[] args) throws Exception{
        //运行服务器
        Server.start();
        //避免客户端先于服务器启动前执行代码
        Thread.sleep(100);
        //运行客户端
        Client.start();
        while(Client.sendMsg(new Scanner(System.in).nextLine()));
    }
}