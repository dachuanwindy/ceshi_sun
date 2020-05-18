package ES.ESapp.Esapp_1;


/**
 * @author sunfch
 * @create 2018-10-29 21:18
 * @desc 第一个es程序
 **/
public class ESsearche {

    public static void main(String[] args) throws ClassNotFoundException {

        Class<?> aClass = Class.forName("inspur.fanshe.testclass.Student");

        Class<?>[] interfaces = aClass.getInterfaces();

        System.out.println(interfaces);
    }
}
