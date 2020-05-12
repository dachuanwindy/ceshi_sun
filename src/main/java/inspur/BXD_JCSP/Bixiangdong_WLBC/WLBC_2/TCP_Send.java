package inspur.BXD_JCSP.Bixiangdong_WLBC.WLBC_2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * TCP 客户端编程，客户端编程比较简单，
 * <p>
 * 第一步： 建立socket("IP", port)
 * <p>
 * 第二步： 建立 输出流，outputstream out =s.getoutputstream
 * <p>
 * 第三步： 向输出流里写东西：  out.write();
 * <p>
 * 第四步：关闭socket
 */
public class TCP_Send {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.1.199", 40017);
        OutputStream out = socket.getOutputStream();
        out.write("sunfengchuan".getBytes());

        byte[] in_stream = new byte[1024];
        InputStream in = socket.getInputStream();
        int in_msg = in.read(in_stream);
        System.out.println(new String(in_stream, 0, in_msg));
        socket.close();


    }
}
