package com_3;


import com.alibaba.fastjson.JSON;
import lombok.Data;

/**
 * @author sunfch
 * @description: 解析json 字符串
 * @date 2019/9/9 15:10
 */
public class ParseJson {


    public static void main(String[] args) {

        String xmlstr = "{\n" +
                "    \"return_code\":\"SUCCESS\",\n" +
                "    \"return_msg\":\"OK\"\n" +
                "}";

        InnerClass22 innerClass22 = JSON.parseObject(xmlstr, InnerClass22.class);
        System.out.println("输出结果是"+innerClass22.toString());

    }


}


@Data
class InnerClass22 {

    private String return_code;

    private String return_msg;

}
