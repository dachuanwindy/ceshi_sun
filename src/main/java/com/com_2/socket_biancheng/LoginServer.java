package com.com_2.socket_biancheng;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description: //TODO  服务端对输入来的数据进行校验，
 * @Author: sunfch
 * @Date: 2019/1/3 23:37
 * @Param:
 * @Return:
 */
public class LoginServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10086);

        while (true) {

            // 获取客户端线程，然后做相应的判断
            Socket socket = serverSocket.accept();
            new Thread(new Userthread(socket)).start();
        }
    }
}

class Userthread implements Runnable {

    private Socket socket;

    public Userthread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        String ip = socket.getInetAddress().getHostAddress();
        System.out.println("当前客户端的IP地址为" + ip);

        for (int i = 0; i < 3; i++) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                // 获取客户端输入的用户名信息
                String name = bufferedReader.readLine();
                if ("lisi".equals(name)) {
                    System.out.println("======>" + "登录成功");
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}