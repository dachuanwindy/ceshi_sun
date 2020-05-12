package com.RPC.DobboDemo;

import thrift_study.thrift_study.HelloServiceImpl;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * @author sunfch
 * @create 2018-10-15 16:36
 * @desc Main函数测试Dobbo
 **/
public class TestMain {

    public static void main(String[] args) throws IOException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Server serviceServer = new ServiceCenter(8088);
                    serviceServer.register(HelloService.class, HelloServiceImp.class);
                    serviceServer.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        HelloService service = RPCClient.getRemoteProxyObj(HelloService.class, new InetSocketAddress("localhost", 8088));
        System.out.println(service.Hello("test"));
    }
}
