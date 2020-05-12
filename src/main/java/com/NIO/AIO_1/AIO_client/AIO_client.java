package com.NIO.AIO_1.AIO_client;

import com.sun.jersey.api.client.async.AsyncClientHandler;

import java.nio.channels.CompletionHandler;

/**
 * @author sunfch
 * @create 2018-06-03 23:37
 * @desc 客户端
 **/
public class AIO_client {

    private static  String default_host="127.0.0.1";
    private  static  int default_port=12345;
    private  static  int aa;

}





class AsynClienthandler implements CompletionHandler<Void,AsyncClientHandler>,Runnable{
    @Override
    public void run() {

    }

    @Override
    public void completed(Void result, AsyncClientHandler attachment) {

    }

    @Override
    public void failed(Throwable exc, AsyncClientHandler attachment) {

    }
}