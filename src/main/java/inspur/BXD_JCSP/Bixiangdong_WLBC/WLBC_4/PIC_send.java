package inspur.BXD_JCSP.Bixiangdong_WLBC.WLBC_4;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class PIC_send {


    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.0.111", 10110);

        FileInputStream fileInputStream = new FileInputStream("D:\\111.jpg");

//        socket.getInputStream(new FileInputStream( fileInputStream));
        OutputStream out = socket.getOutputStream();
        byte[] byt = new byte[1024];

        int len = 0;
        while ((len = fileInputStream.read(byt)) != -1) {
            out.write(byt, 0, len);
        }

        socket.shutdownOutput();


        InputStream in = socket.getInputStream();

        byte[] inread = new byte[1024];
        int num = in.read(inread);

        System.out.println(new String(inread, 0, num));

        in.close();
        socket.close();


    }
}
