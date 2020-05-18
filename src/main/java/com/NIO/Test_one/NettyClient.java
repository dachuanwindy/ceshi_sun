package com.NIO.Test_one;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author sunfch
 * @version V1.0
 * @Description: Netty客户端
 * @date 2020/4/15 11:38
 */
public class NettyClient {

    static final String HOST = System.getProperty("host", "127.0.0.1");
    static final int PORT1 = Integer.parseInt(System.getProperty("port", "8765"));
    static final int PORT2 = Integer.parseInt(System.getProperty("port", "8764"));

    public static void main(String[] args) throws InterruptedException {

        EventLoopGroup workgroup = new NioEventLoopGroup();
        Bootstrap b = new Bootstrap();//客户端
        b.group(workgroup)
                .channel(NioSocketChannel.class)//客户端 -->NioSocketChannel
                .option(ChannelOption.SO_KEEPALIVE, true)
                .handler(new ChannelInitializer<SocketChannel>() {//handler
                    @Override
                    protected void initChannel(SocketChannel sc) throws Exception {
                        sc.pipeline().addLast(//new ClientHandler());
                        );
                    }
                });
        //创建异步连接 可添加多个端口
        ChannelFuture cf1 = b.connect(HOST, PORT1).sync();
        ChannelFuture cf2 = b.connect(HOST, PORT2).sync();

        //buf
        //client向server端发送数据  Buffer形式
        cf1.channel().writeAndFlush(Unpooled.copiedBuffer("hello netty".getBytes()));
        cf2.channel().writeAndFlush(Unpooled.copiedBuffer("hello world".getBytes()));


        cf1.channel().closeFuture().sync();
        cf2.channel().closeFuture().sync();

        workgroup.shutdownGracefully();

    }
}
