package shejimoshi.Factory_Mode.factory2.impl;

import shejimoshi.Factory_Mode.factory2.IRead;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 定义泛型, 并且泛型在实际中的使用
 * @date 2021/7/2 09:29
 */

public class TextReadImpl implements IRead<String> {
    @Override
    public String read(String in) {
        System.out.println("读取数字类型的参数");
        return "hello,真正实现泛型的使用";
    }
}
