package com.socket_study.UDP;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * 1.TCP是面向连接的，连接之前需要进行三次握手，释放连接需要四次挥手等操作，这样是比较耗费CPU资源你的，传输速度没有UDP快
 * 优点是:传输稳定，
 * 2 UDP是无连接的，省去了三次握手等操作，传输速度快，缺点是：有网络影响比较严重，容易丢包，在传输比较重要的信息的时候选择TCP，
 * 对传输质量要求没有那么高的情况下，可以选择UDP
 * <p>
 * 3.TCP能保证传输的次序，但是UDP不能保证；
 */
public class UDPtest {
}


class UDPserver {

    public static void main(String[] args) throws IOException {
        DatagramSocket server = new DatagramSocket(9998);

        while (true) {


            byte[] bytes = new byte[1024];

            DatagramPacket packet1 = new DatagramPacket(bytes, 0, bytes.length);
            server.receive(packet1);
            String data = new String(bytes, 0, packet1.getLength());
            System.out.println("====>" + data);
        }
    }
}

class UDPclient {
    public static void main(String[] args) throws IOException {
        byte[] bytes = new byte[1024];

        while (true) {
            DatagramPacket datagramPacket = new DatagramPacket(bytes, 0, 1024);
            datagramPacket.setData("sunfengchuan".getBytes());
            datagramPacket.setPort(9998);
            datagramPacket.setAddress(InetAddress.getLocalHost());
            DatagramSocket client = new DatagramSocket();
            client.send(datagramPacket);
            client.close();
        }
    }
}