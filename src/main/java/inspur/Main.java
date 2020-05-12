package inspur;

import inspur.interface_impl.interface_impl;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;

public class Main {
    interface_impl impl = new interface_impl();

    public static void main(String[] args) {
        /*interface_impl impl = new interface_impl();
        String money = "100";
        String shopping = "恒隆商城";

        String xianshi = impl.eat_zhaji(null, null);
        System.out.println("能正常输出---=====>>>>" + xianshi);

        Main ee = new Main();
        ee.ceshimethod();


        System.out.println("输出读取配置文件相关操作--start");
        Reading_properties rs = new Reading_properties();
        rs.inticonfig();
        System.out.println("输出读取配置文件相关操作---end");*/


        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put("","");

        testIsNotblank();
    }

    public void ceshimethod() {

        impl.eat_zhaji(null, null);
    }


    public static void testIsNotblank() {

        String str = " ";
        boolean notBlank = StringUtils.isNotBlank(str);

        boolean notEmpty = StringUtils.isNotEmpty(str);
        System.out.println(notEmpty);

        System.out.println(notBlank);

    }
}
