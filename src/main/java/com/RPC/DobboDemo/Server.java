package com.RPC.DobboDemo;

import java.io.IOException;

/**
 * @author sunfch
 * @create 2018-10-15 15:44
 * @desc server端接口生命
 **/
public interface Server {

    void stop();

    void start() throws IOException;

    void register(Class serviceInterface, Class impl);   //服务注册

    boolean isRunning();

    int getPort();
}
