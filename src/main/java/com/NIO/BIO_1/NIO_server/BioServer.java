package com.NIO.BIO_1.NIO_server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 阻塞服务端
 * @date 2020/5/17 20:08
 */
public class BioServer {
    public static void main(String[] args) throws IOException {


        byte[] bytes = new byte[1024];
        ServerSocket serverSocket = new ServerSocket(12345);

        while (true) {
            Socket accept = serverSocket.accept();
            accept.getInputStream().read(bytes);
            // 输出我要输出的内容
            System.out.println(new String(bytes));
        }

    }
}
