package inspur.BXD_JCSP.Bixiangdong_WLBC.WLBC_4;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class PIC_Reciv {

    public static void main(String[] args) throws IOException {

        ServerSocket ss = new ServerSocket(10110);
        while (true) {
            Socket socket = ss.accept();
            new Thread(new A(socket)).start();
        }
    }
}


class A implements Runnable {

    private Socket socket;

    A(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        String ip = socket.getInetAddress().getHostAddress();
        System.out.println(ip + "..... 连接成功");
        int i = 1;
        try {
            InputStream filein = null;
            try {
                filein = socket.getInputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }

            FileOutputStream fout = null;
            try {
                File file = new File("D:\\"+ip + "(" + (i++) + ")" + ".jpg");

                while (file.exists())
                    file = new File("D:\\"+ip + "(" + (i++) + ")" + ".jpg");

                fout = new FileOutputStream(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            byte[] fin = new byte[1024];
            int len = 0;
            while ((len = filein.read(fin)) != -1) {
                fout.write(fin, 0, len);
            }

            OutputStream output = socket.getOutputStream();
            output.write("wenjian yijng shodoa".getBytes());

            fout.close();

        } catch (Exception e) {

            throw new RuntimeException(ip + "连接失败");
        }


    }
}
