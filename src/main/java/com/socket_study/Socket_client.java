package com.socket_study;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


/**
 * @Description: UDP  发送数据接收数据
 * @Author: sunfch
 * @Date: 2019/3/3-18:34
 * @Param:
 * @Return:
 */
public class Socket_client {


    //udp 使用datagram 发送数据包
    private DatagramSocket servesocket;

    public void starserver() {
        try {
            InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
            servesocket = new DatagramSocket(12345, inetAddress);
            // 创建接收对象大小 字节接收缓冲区
            byte[] recbuf = new byte[1024];
            // 创建数据包接收区
            DatagramPacket packet = new DatagramPacket(recbuf, 1024);

            while (true) {
                try {
                    servesocket.receive(packet);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String recived = new String(recbuf, 0, packet.getLength());

                // 回写数据： 思路是：首先要会写到数据的地址和端口号，然后通过packet 回传数据
                InetAddress address = packet.getAddress();
                int port = packet.getPort();
                byte[] senddata = new byte[1024];
                senddata = recived.getBytes();
                DatagramPacket sendpacket = new DatagramPacket(senddata, senddata.length, address, port);

                try {
                    servesocket.send(sendpacket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String arsg[]) {
        Socket_client socket_client = new Socket_client();
        socket_client.starserver();


    }
}
