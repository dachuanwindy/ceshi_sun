package thrift_study.thrift_study;

/**
 * @author sunfch
 * @create 2018-03-26 23:11
 * @desc 服务端
 **/

import org.apache.thrift.TException;
import thrift_study.Hello;

public class HelloServiceImpl implements Hello.Iface {

    @Override
    public String helloString(String para) throws TException {
        return "孙风川，好好学习，好好搞技术" + para;
    }


}