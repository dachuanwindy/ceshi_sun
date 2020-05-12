package NIO_study.NIO_block;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author sunfch
 * @create 2018-11-25 16:44
 * @desc 客户端写入数据
 **/
public class Client {

    public static void client() throws IOException {

        //建立连接；
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8888));

        // 创建通道
        FileChannel inchannel = FileChannel.open(Paths.get("11.jpg"), StandardOpenOption.READ);

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        while (inchannel.read(byteBuffer) != -1) {

            byteBuffer.flip();

            socketChannel.write(byteBuffer);

            byteBuffer.clear();

        }

        int len=0;
        while((len=socketChannel.read(byteBuffer))!=-1){
            byteBuffer.flip();
            System.out.println(new String(byteBuffer.array(),0,len));
            byteBuffer.clear();
        }

        inchannel.close();
        socketChannel.close();
    }

    public static void main(String[] args) throws IOException {
        client();
    }
}
