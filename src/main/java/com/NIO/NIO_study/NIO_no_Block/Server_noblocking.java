package com.NIO.NIO_study.NIO_no_Block;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Iterator;

/**
 * @author sunfch
 * @create 2018-11-25 18:05
 * @desc 非阻塞式服务端
 **/
public class Server_noblocking {

    public static void server() throws IOException {

        // sever端打开连接
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // 监听接口---
        serverSocketChannel.bind(new InetSocketAddress(8889));
        // 获取接口的client端channel
        SocketChannel socketChannel = serverSocketChannel.accept();

        FileChannel outchannel = FileChannel.open(Paths.get("ddd.jpg"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        //这个是NIO的特点： 多了一个选择器，这个，然后将将连接通道注册到selector中，并根据状态进行监控，
        // 中心思想是:用一个线程始终去监控 channel的状态，并根据状态进行操作；
        Selector selector = Selector.open();

        serverSocketChannel.register(selector, SelectionKey.OP_READ);

        while (selector.select() > 0) { // 这个时候证明有通道注册进来了

            Iterator<SelectionKey> it = selector.selectedKeys().iterator();

            while (it.hasNext()) {

                SelectionKey sk = it.next();

                if (sk.isAcceptable()) {
                    SocketChannel schannel = (SocketChannel) sk.channel();
                    schannel.configureBlocking(false);
                    schannel.register(selector, SelectionKey.OP_READ);


                } else if (sk.isReadable()) {

                    SocketChannel schannel2 = (SocketChannel) sk.channel();

                    ByteBuffer byteBuffer1 = ByteBuffer.allocate(1024);

                    while (schannel2.read(byteBuffer) != -1) {

                    }

                }
            }
            it.remove();
        }
    }
}
