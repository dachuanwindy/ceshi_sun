package inspur.fanshe.testclass.Interface;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author sunfch
 * @create 2018-07-21 23:21
 * @desc 读取配置文件，并相对路径绝对路径读取配置文件
 **/
public class Properties_study {
    public static void main(String args[]) throws IOException {

        System.out.println("加载配置文件测试");

        Properties p = new Properties();
        InputStream in = Properties_study.class.getResourceAsStream("ceshi.properties");
        p.load(in);
        String add = p.getProperty("ADD");
        System.out.println(add);
    }


}

