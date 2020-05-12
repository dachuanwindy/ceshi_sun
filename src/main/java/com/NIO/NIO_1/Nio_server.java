package com.NIO.NIO_1;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/**
 * @author sunfch
 * @create 2018-06-03 12:17
 * @desc NIO 客户端
 **/
public class Nio_server {
    public static void main(String args[]) {

        new Thread().start();

    }

    public static class NIO_serer implements Runnable {

        private Selector selector;

        public NIO_serer() {

            try {
                // 打开服务端socket channel;
                ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
                // 绑定端口号
                serverSocketChannel.socket().bind(new InetSocketAddress(InetAddress.getLocalHost(), 8990));
                // 设置channel模式为非阻塞模式
                serverSocketChannel.configureBlocking(false);
                //创建多路复用器，并开启线程
                selector = Selector.open();
                // 将channel 注册到selector 选择器中
                SelectionKey key = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        @Override
        public void run() {

        }
    }


}
