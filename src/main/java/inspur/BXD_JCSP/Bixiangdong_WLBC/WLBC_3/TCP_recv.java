package inspur.BXD_JCSP.Bixiangdong_WLBC.WLBC_3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 应用场景：当从键盘上输入字段，并将字段传到另一台计算机上，这样就
 */
public class TCP_recv {

    public static void main(String[] args) throws IOException {

        ServerSocket ss = new ServerSocket(10015);
        Socket socket = ss.accept();
        InputStream in = socket.getInputStream();
        BufferedReader bfr = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        PrintWriter printWriter = new PrintWriter(new FileWriter("E:\\dfdfdfd.java"), true);

        String inlin = null;
        while ((inlin = bfr.readLine()) != null) {
            printWriter.print(inlin);
        }
        PrintWriter pw = new PrintWriter(socket.getOutputStream());
        pw.print("shangchuan chenggong");

        pw.close();
        socket.close();
    }
}
