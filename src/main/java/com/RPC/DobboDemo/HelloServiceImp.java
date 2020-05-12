package com.RPC.DobboDemo;

import java.io.Serializable;

/**
 * @author sunfch
 * @create 2018-10-15 15:42
 * @desc HelloService接口实现
 **/
public class HelloServiceImp implements HelloService,Serializable {
    @Override
    public String Hello(String name) {
        return name + "local";
    }
}
