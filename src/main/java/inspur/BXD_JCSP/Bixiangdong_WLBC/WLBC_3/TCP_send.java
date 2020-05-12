package inspur.BXD_JCSP.Bixiangdong_WLBC.WLBC_3;

import java.io.*;
import java.net.Socket;

public class TCP_send {

    public static void main(String[] args) throws IOException {
        Socket socket = null;
        PrintWriter printWriter = null;
        System.out.println("视频教程测试····");
        try {
            socket = new Socket("192.168.1.199", 10015);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader bfr = new BufferedReader(new FileReader("D:\\开发积累.java"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            printWriter = new PrintWriter(socket.getOutputStream(), true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        BufferedReader in_read = new BufferedReader(new InputStreamReader(socket.getInputStream()));


        String str = in_read.readLine();
        System.out.println("=====>" + str);

        in_read.close();
        socket.close();


    }
}
