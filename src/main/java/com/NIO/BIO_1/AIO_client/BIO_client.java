package com.NIO.BIO_1.AIO_client;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author sunfch
 * @create 2018-06-03 23:37
 * @desc 客户端
 **/
public class BIO_client {

    private static String default_host = "127.0.0.1";
    private static int default_port = 12345;
    private static int aa;

    public static void main(String[] args) throws IOException {
        byte[] bytes = new byte[1024];
        Socket socket = new Socket(default_host, default_port);
        socket.getOutputStream().write("孙风川".getBytes());
        socket.getInputStream().read(bytes);
        System.out.println(new String(bytes));
        socket.close();

    }


}

class serverTest {

    public static void main(String[] args) throws IOException {
        Server();
    }

    public static void Server() throws IOException {

        ServerSocket socketServer = new ServerSocket(12345);

        while (true) {
            Socket accept = socketServer.accept();
            System.out.println("就卡在这====");

            byte[] bytes = new byte[1024];
            int read = accept.getInputStream().read(bytes);
            System.out.println(read);
            System.out.println(new String(bytes));
            accept.close();
        }
    }


    public  static  void  serverNIO () throws IOException {


        SocketChannel socketChannel = SocketChannel.open();



    }

}

