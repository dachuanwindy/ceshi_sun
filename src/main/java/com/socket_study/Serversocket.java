package com.socket_study;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Serversocket {

    private DatagramSocket clientsocket;

    public String serveclient(String str) {
        String recived = "";

        try {
            clientsocket = new DatagramSocket();
            byte[] clientsend = new byte[1024];
            clientsend = str.getBytes();
            InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
            DatagramPacket datagramPacket = new DatagramPacket(clientsend, clientsend.length, inetAddress, 12345);

            clientsocket.send(datagramPacket);

            byte[] client_recvd = new byte[1024];
            DatagramPacket recieved_data = new DatagramPacket(client_recvd, client_recvd.length);

            clientsocket.receive(recieved_data);

            recived = new String(recieved_data.getData(), 0, recieved_data.getLength());


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (clientsocket != null) {
                clientsocket.close();
            }
        }
        return recived;
    }

    public static void main(String args[]) {

        Serversocket serversocket = new Serversocket();
        serversocket.serveclient("123456789");
    }
}


