package inspur.BXD_JCSP.Bixiangdong_IO.Properties_study;

import javax.xml.ws.spi.Invoker;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Test_main {

    public static void main(String[] args) throws IOException {
        System.out.println("配置文件读取学习");


//        向配置文件中写入数据
/*        OutputStream outputStream = new FileOutputStream("D:\\properties.property");
        Properties properties = new Properties();
        properties.setProperty("sunfnegchuan", "sunfengchuan11111");
        properties.setProperty("sunfnegchuan2", "sunfengchuan11111");
        properties.setProperty("sunfnegchuan3", "sunfengchuan11111");
        properties.setProperty("sunfnegchuan4", "sunfengchuan11111");
        properties.store(outputStream, "");*/


        //读取配置文件中的数据

      /*  BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("D:\\properties.property"));
        byte[] bff = new byte[bufferedInputStream.available()];
        int len = 0;
        while ((len = bufferedInputStream.read()) != -1) {
            System.out.println(new String(bff, 0, len)); }*/

        prorpereties_study_1();
        ceshi_2();

        String jmzd = "2-3;5-3;9-2";

        Map<String, Integer> map_2 = new HashMap<String, Integer>();
        String[] jmzd_parase = jmzd.split(";");
        int len = jmzd_parase.length;

        for (int i = 0; i < jmzd_parase.length; i++) {
            String[] a = jmzd_parase[i].split("-");
            map_2.put("Index" + i, Integer.parseInt(a[0]));
            map_2.put("Length" + i, Integer.parseInt(a[1]));
        }



    }

    //    读取jvmp配置文件
    public static void prorpereties_study_1() {
        Properties pps = System.getProperties();
        pps.list(System.out);
    }

    public static void ceshi_2() {

        Map<String, String> map_1 = new HashMap<String, String>();

        map_1.put("e", "");
        map_1.get("e");
        System.out.println(map_1.get("e"));
    }
}


class C {

    public String Test1(String name) {

        System.out.println("invoke调用");
        return name;
    }

}