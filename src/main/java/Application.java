import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sun.nio.ch.DirectBuffer;

/**
 * @author sunfch
 * @version V1.0
 * @Description: TODO
 * @date 2020/4/4 09:16
 */
public class Application {


    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("application.xml");

        ac.getBean("aaaaaa");

        DirectBuffer directBuffer= null;
    }
}
