package inspur.BXD_JCSP.Bixiangdong_WLBC.WLBC1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpRes {

    public static void main(String[] args) throws IOException {
        System.out.println("接收信息---");

        DatagramSocket ds = new DatagramSocket(10000);
            byte[] reciv = new byte[1024];
            DatagramPacket dp = new DatagramPacket(reciv, reciv.length);
            ds.receive(dp);
            String rec = new String(dp.getData(), 0, dp.getLength());
            System.out.println("接收到的消息====》" + rec);

            ds.close();



    }
}
