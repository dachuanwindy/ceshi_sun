package inspur.BXD_JCSP.Bixiangdong_WLBC.WLBC_2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 客户端接收数据：
 * <p>
 * 第一步:首先建立服务端对象；Serversocket
 * <p>
 * 第二步：建立客户端对象， 从服务端对象那里接收 客户端对象，Socket socket = serversocket.accpet();
 * <p>
 * 第三步； 客户端接收客户端inputstream  存放到已经建立好的缓冲区中，这样数据就能接收到，
 * <p>
 * 第四步： 用string 类型接收 byte[]中的数据，并打印
 * <p>
 * 第五步；关闭连接。收工。
 */

public class TCP_Recvied {
    public static void main(String[] args) throws IOException, InterruptedException {

        ServerSocket ss = new ServerSocket(40017);
        //获取客户端对象，并拿客户端对象与之比较，如果是这个对象，
        Socket socket = ss.accept();

        String ip = socket.getInetAddress().getHostAddress();
        System.out.println("输出的Ip地址为" + ip);

        // 接收客户端来的数据流。并将数据流存放到buffer区中
        InputStream in = socket.getInputStream();
        byte[] inbuf = new byte[1024];
        int len = in.read(inbuf);
        String sss = new String(inbuf, 0, len);

        System.out.println("输出的东西是：" + sss);

        OutputStream out = socket.getOutputStream();

        Thread.sleep(10000);
        out.write("我已经收到消息了".getBytes());
        socket.close();
        ss.close();
    }
}
