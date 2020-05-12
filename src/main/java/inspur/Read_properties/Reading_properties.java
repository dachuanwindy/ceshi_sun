package inspur.Read_properties;



import java.io.InputStream;
import java.util.Properties;

public class Reading_properties {

    public void inticonfig() {

        Properties ps = new Properties();

        try {
            System.out.println("开始读取配置文件");
            InputStream in = ClassLoader.class.getClassLoader().getResourceAsStream("ceshi.properties");
            //E:\工作\河南\sx_tax\03_产品研发\01_Trunk\study\src\ceshi.properties
            //    InputStream in = RedisUtil.class.getResourceAsStream("\\java\\Resource\\ceshi.properties");
            //E:\工作\河南\sx_tax\03_产品研发\01_Trunk\study\src\main\java\Resource\ceshi.properties
            ps.load(in);
            String ceshi = ps.getProperty("sunfengchuan");
            System.out.println("读取的配置文中：姓名为：" + ceshi);
            String add = ps.getProperty("ADD");


        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("读取文件失败··");


    }
}
