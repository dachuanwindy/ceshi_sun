package com.com_2.socket_biancheng;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


/**
 * @Description: //TODO  登录客户端，登录信息，若能登录信息就返回数据
 * 其实就是socket 编程，
 * @Author: sunfch
 * @Date: 2019/1/3 23:24
 * @Param:
 * @Return:
 */
public class LoginClient {
    public static void main(String[] args) throws IOException {

        /*网络编程，将信息发送到指定的客户端 端口号为：10086*/
        Socket socket = new Socket("127.0.0.1", 10086);

        //键盘段输入信息
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        //将信息输出；
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        BufferedReader bfin = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        for (int i = 0; i < 3; i++) {
            String inline = bufferedReader.readLine();
            out.println(inline);
            String bfinline = bfin.readLine();
            System.out.println(bfinline);
        }
        bfin.close();
        out.close();
    }

}
