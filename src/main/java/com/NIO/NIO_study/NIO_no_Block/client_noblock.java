package com.NIO.NIO_study.NIO_no_Block;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author sunfch
 * @create 2018-11-25 17:57
 * @desc 非阻塞式线程
 **/
public class client_noblock {

    public static void client() throws IOException {

        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8889));

        FileChannel inchannel = FileChannel.open(Paths.get("11.jpg"), StandardOpenOption.READ);

        socketChannel.configureBlocking(false);
        // 转换成非阻塞式模式

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        while (inchannel.read(byteBuffer) != -1) {
            byteBuffer.flip();
            socketChannel.write(byteBuffer);
            byteBuffer.clear();
        }

        socketChannel.close();
        inchannel.close();
    }

    public static void main(String[] args) throws IOException {
        client();
    }
}
