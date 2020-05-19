package com.NIO.AIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 异步模型, 线程多了,有了线程切换造成浪费 ,
 * <p>  AIO  异步IO模型,实现方式简单理解: 实现异步的方式---> completionHandler 接收到消息之后,执行这个方法;
 *
 * asynchronous
 * @date 2020/5/18 13:20
 */
public class AIOServerTest {

    public static void main(String[] args) throws IOException, InterruptedException {

        AsynchronousServerSocketChannel channel = AsynchronousServerSocketChannel.open();
        channel.bind(new InetSocketAddress(12345));
        // 这个叫钩子方法, 当执行完之后调用 这个里面的方法, 例如:代理模式中的方法
        channel.accept(null, new CompletionHandler<AsynchronousSocketChannel, Object>() {
            @Override
            public void completed(AsynchronousSocketChannel client, Object attachment) {
                channel.accept(null, this);
                try {
                    System.out.println(client.getRemoteAddress());
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    client.read(buffer, buffer, new CompletionHandler<Integer, ByteBuffer>() {
                        @Override
                        public void completed(Integer result, ByteBuffer attachment) {
                            attachment.flip();
                            System.out.println(new String(attachment.array(), 0, result));
                            client.write(ByteBuffer.wrap("HelloClient".getBytes()));
                        }

                        @Override
                        public void failed(Throwable exc, ByteBuffer attachment) {
                            exc.printStackTrace();
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void failed(Throwable exc, Object attachment) {
                exc.printStackTrace();
            }
        });

        while (true) {
            Thread.sleep(1000);
        }

    }
}
