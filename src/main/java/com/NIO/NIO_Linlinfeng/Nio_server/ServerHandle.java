package com.NIO.NIO_Linlinfeng.Nio_server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author sunfch
 * @create 2018-06-03 16:05
 * @desc ServerHandle线程实现
 **/
public class ServerHandle implements Runnable {
    private String host;
    private int port;

    // 多路复用器
    private Selector selector;
    // 可选择的通道
    private ServerSocketChannel serverchannel;

    private volatile boolean started;

    public ServerHandle(int port) {
        try {
            //打开多路选择器
            selector = Selector.open();
            // 打开多路通道
            serverchannel = ServerSocketChannel.open();
            // 1024 是什么意思？
            serverchannel.socket().bind(new InetSocketAddress(port), 1024);
            // 设定为非阻塞式io
            serverchannel.configureBlocking(false);
            //将端口注册到selector;
            serverchannel.register(selector, SelectionKey.OP_ACCEPT);
            //标记开启服务
            started = true;
            System.out.println("服务端已经开启服务。。。" + port);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("服务端开启服务失败");
        }

    }

    public void stop() {
        started = false;
    }

    //
    @Override
    public void run() {

        while (started) {
            try {
                selector.select(1000);
                Set<SelectionKey> keys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = keys.iterator();
                SelectionKey key = null; //这句是什么意思？  保存一个key值，作为一个变量供给下面使用
                while (iterator.hasNext()) {
                    key = iterator.next();
                    iterator.remove();//遍历完之后就移除掉一个key值
                    try {
                        handleInput(key);
                    } catch (Exception e) { // 当出现异常的时候，该如何去做。。。
                        if (key != null) {
                            key.cancel();
                            if (key.channel() != null) {
                                key.channel().close();
                            }
                        }
                    }
                }
            } catch (IOException e) {
                System.out.println("输出异常");
                e.printStackTrace();
            }
        }

        if (selector != null)
            try {
                selector.close();
            } catch (Exception e) {
                System.out.println("输出异常---2");
                e.printStackTrace();
            }

        if (selector != null)
            try {
                selector.close();
            } catch (
                    Exception e)

            {
                e.printStackTrace();
            }
    }



    // 处理input业务信息
    // 接收key的目的就是： 重新建立一个通道，通过这个通道然后去与key 对应的通道对接
    private void handleInput(SelectionKey key) throws IOException {
        if (key.isValid()) { // 判断如果有效。
            if (key.isAcceptable()) {
                ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel(); //通过key找到相应的通道

                SocketChannel socketChannel = serverSocketChannel.accept();
                // 设置为非阻塞式io
                socketChannel.configureBlocking(false);
                //注册为读消息
                socketChannel.register(selector, SelectionKey.OP_READ);
            }
            if (key.isReadable()) {

                SocketChannel socketChannel = (SocketChannel) key.channel();

                ByteBuffer buffer = ByteBuffer.allocate(1024);
                int readbyte = socketChannel.read(buffer);

                if (readbyte > 0) {
                    buffer.flip();

                    byte byte1[] = new byte[buffer.remaining()];
                    buffer.get(byte1);
                    String exption = new String(byte1, "utf-8");
                    System.out.println("服务端收到的消息是：" + exption);
                    String result = "";
                    try {
                        result = "现在的结果就是我们要输出的结果。。。";
                    } catch (Exception e) {
                        System.out.println(" 输出结果有误。。。");
                    }
                    dowrite(socketChannel, result); // 这个是调用的结果，
                }
            }


        }


    }

    //处理应答信息
    private void dowrite(SocketChannel channel, String response) throws IOException {

        byte bte[] = response.getBytes();

        ByteBuffer writebffer = ByteBuffer.allocate(bte.length);

        writebffer.put(bte); // 获取当前的结果，放入buffer中

        writebffer.flip();// 写到缓冲区中，

        channel.write(writebffer);// 向通道内写入数据，这样就能完成发送

    }

}