package Java_JC.Soket_study;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Socket_study {

    public static void main(String[] args) {


    }
}

class soketserver implements Runnable {

    public void serversocket() throws IOException {


    }


    @Override
    public void run() {
        ServerSocket serverSocket = null;
        try {
            String readline = null;
            String intemp = null;
            serverSocket = new ServerSocket(8080);
            Socket socket = serverSocket.accept();
            BufferedReader systemin = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader socketin = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter socketout = new PrintWriter(socket.getOutputStream());

            while (readline != "bye") {
                intemp = socketin.readLine();
                System.out.println("client" + ">>" + intemp);
                readline = systemin.readLine();
                socketout.println(readline);
                socketout.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}


/**
 * @Description: 客户端实现
 * @Author: sunfch
 * @Date: 2019/2/20-20:35
 * @Param:
 * @Return:
 */
class socketclient implements Runnable {


    @Override
    public void run() {
        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1", 8080);
            socket.getInputStream();
            socket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}