package shejimoshi.Brige_mode.brige_mode;

import java.sql.Driver;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 调用端测试
 * @date 2020/5/1 19:12
 */
public class ClientTest {

    public static void main(String[] args) throws ClassNotFoundException {
        Phone phone = new SlidePhone(new HuaWeiPhone());
        phone.call();

        Class.forName("");
    }
}
