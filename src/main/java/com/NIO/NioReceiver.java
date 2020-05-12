package com.NIO;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NioReceiver {
    @SuppressWarnings("null")
    public static void main(String[] args) throws Exception {
        ByteBuffer echoBuffer = ByteBuffer.allocate(8);
        ServerSocketChannel ssc = ServerSocketChannel.open();// 通道，这个是双向通道
        Selector selector = Selector.open();
        ssc.configureBlocking(false);
        ServerSocket ss = ssc.socket();
        InetSocketAddress address = new InetSocketAddress(8080);
        ss.bind(address);
        SelectionKey key = ssc.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("开始监听……");
        while (true) {
            int num = selector.select();
            Set selectedKeys = selector.selectedKeys();
            Iterator it = selectedKeys.iterator();
            while (it.hasNext()) {
                SelectionKey sKey = (SelectionKey) it.next();
                SocketChannel channel = null;
                if (sKey.isAcceptable()) {
                    ServerSocketChannel sc = (ServerSocketChannel) key.channel();
                    channel = sc.accept();// 接受连接请求
                    channel.configureBlocking(false);
                    channel.register(selector, SelectionKey.OP_READ);
                    it.remove();
                } else if (sKey.isReadable()) {
                    channel = (SocketChannel) sKey.channel();
                    while (true) {
                        echoBuffer.clear();
                        int r = channel.read(echoBuffer);
                        if (r <= 0) {
                            channel.close();
                            System.out.println("接收完毕，断开连接");
                            break;
                        }
                        System.out.println("##" + r + " " + new String(echoBuffer.array(), 0, echoBuffer.position()));
                        echoBuffer.flip();
                    }
                    it.remove();
                } else {
                    channel.close();
                }
            }
        }

    }

}