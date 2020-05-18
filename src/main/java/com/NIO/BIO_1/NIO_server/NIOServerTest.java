package com.NIO.BIO_1.NIO_server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author sunfch
 * @version V1.0
 * @Description: NIO 具体实现
 *
 * Reactor模型: 当来个一个连接,就让
 * @date 2020/5/17 20:26
 */
public class NIOServerTest {

    public static void main(String[] args) throws IOException {

        byte[] bytes = new byte[1024];
        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        SocketAddress socketAddress = new InetSocketAddress("127.0.0.1", 12345);
        socketChannel.bind(socketAddress);
        socketChannel.configureBlocking(false);

        // 创建selector对象
        Selector selector = Selector.open();
        socketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            int nReady = selector.select();
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> it = keys.iterator();

            while (it.hasNext()) {
                SelectionKey key = it.next();
                it.remove();

                if (key.isAcceptable()) {
                    // 创建新的连接，并且把连接注册到selector上，而且，
                    // 声明这个channel只对读操作感兴趣。
                    SocketChannel s1 = socketChannel.accept();
                    ByteBuffer readBuff = ByteBuffer.allocate(1024);
                    s1.read(readBuff);

                    System.out.println("hhhhhhh=====HHHH" + readBuff);
                   // socketChannel.register(s1,SelectionKey.OP_READ);
                    String s = new String();

                } else if (key.isReadable()) {


                    SocketChannel socketChannel2 = (SocketChannel) key.channel();
                    socketChannel2.read(ByteBuffer.wrap(bytes));
                    System.out.println("received : " + new String(bytes));
                    key.interestOps(SelectionKey.OP_WRITE);
                }
            }
        }
    }
}
