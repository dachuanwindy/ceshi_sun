package inspur.BXD_JCSP.Bixiangdong_WLBC.WLBC1;
/**网络编程
 *
 * Udp无协议网络编程，特点：
 *  1.无需连接，传输速度快，
 *  2.实时性好，工作效率比TCP要高，主要用于网络视频，大数据实时网络数据传输
 *  3.对系统资源要求较少。
 *
 *  TCP 是面向连接的， 主要是特点是安全可靠。
 *
 *
 *
 *
 * */
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Udpsend {

    public static void main(String[] args) throws IOException {

        DatagramSocket ds = new DatagramSocket(8888);

        byte[] str = "gfsgsgsfgsgsfgfsgsfgs".getBytes();
        DatagramPacket dp = new DatagramPacket(str, str.length, InetAddress.getByName("192.168.1.199"), 10000);
        ds.send(dp);
        ds.close();
    }
}
