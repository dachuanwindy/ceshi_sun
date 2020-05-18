package com.NIO.Test_one;

import io.netty.channel.nio.NioEventLoopGroup;

import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sunfch
 * @create 2018-11-15 22:37
 * @desc 服务端 netty 测试
 **/
public class HelloServer {

    public static void main(String[] args) throws FileNotFoundException {
//        InputStream inputStream = new FileInputStream("fdf");


        List list = new LinkedList();
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(6);
        list.add(9);
        list.add(2);

        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);

        new NioEventLoopGroup();
    }
}
