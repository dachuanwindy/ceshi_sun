package com.NIO.NIO_study.NIO_block;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author sunfch
 * @create 2018-11-25 16:53
 * @desc 服务端实现
 **/
public class Server {

    public static void server() throws IOException {


        //打开远程通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //创建读取通道
        FileChannel outchannel = FileChannel.open(Paths.get("222.jpg"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);

        // 分配空间
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        //远程绑定端口号 8888
        serverSocketChannel.bind(new InetSocketAddress(8888));


//        获取客户端通道

        SocketChannel socketChannel = serverSocketChannel.accept();

        while (socketChannel.read(byteBuffer) != -1) {
            byteBuffer.flip();
            outchannel.write(byteBuffer);
            byteBuffer.clear();
        }

        String str = "数据已经接受成功";
        byteBuffer.flip();
        byteBuffer.put(str.getBytes());
        socketChannel.write(byteBuffer);


//        关闭通道
        serverSocketChannel.close();
        socketChannel.close();
        outchannel.close();

    }


    public static void main(String[] args) throws IOException {
        server();
    }


    /**
     * @Description: 仿照上面技术实现
     * @Author: sunfch
     * @Date: 2019/2/23-9:30
     * @Param:
     * @Return:
     */


    public void servertest() throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

    }
}
