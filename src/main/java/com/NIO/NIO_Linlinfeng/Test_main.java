package com.NIO.NIO_Linlinfeng;

import com.NIO.NIO_Linlinfeng.Nio_client.Client;
import com.NIO.NIO_Linlinfeng.Nio_server.Nio_server;

import java.util.Scanner;

/**
 * @author sunfch
 * @create 2018-06-03 18:08
 * @desc 测试实现
 **/
public class Test_main {
    @SuppressWarnings("resource")
    public static void main(String[] args) throws Exception{
        //运行服务器
        Nio_server.start(12345);
        //避免客户端先于服务器启动前执行代码
        Thread.sleep(100);
        //运行客户端
        Client.start();
        while(Client.sendMsg(new Scanner(System.in).nextLine()));
    }
}
