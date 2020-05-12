package inspur.fanshe.testmain;

import inspur.fanshe.testclass.Student;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author sunfch
 * @create 2018-07-21 10:21
 * @desc 反射测试类
 **/
public class TestMain {
    public static void main(String args[]) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException, NoSuchFieldException, IOException {

        System.out.println("开始反射之旅");

        //方式一: 这个是new对象的时候通过jvm 自动去寻找并加载student.class  文件到内存中，然后在java 虚拟机内存中生成对象，此时jvm
        // 自动通过【】创建Class对象，然后将student对象装入，返回给程序
        // Class 对象是在加载类时由 Java 虚拟机以及通过调用类加载器中的defineClass 方法自动构造的

//        方式二 就是引入jar 包然后调用方法名字
//        Class classz = Student.class;
//        classz.getPackage();
//        Constructor[] constructor = classz.getConstructors();
//        for (Constructor c : constructor) {
//            System.out.println(c);
//        }


//        方式三 通过class.forname();

        try {
            Class clazz3 = Class.forName("inspur.fanshe.testclass.Student");
            Constructor[] constructor1 = clazz3.getConstructors();
            for (int i = 0; i < constructor1.length; i++) {
                System.out.println("输出" + constructor1[i]);
            }


            constructor1 = clazz3.getDeclaredConstructors();
            for (Constructor con : constructor1) {
                System.out.println("输出声明的方法===》" + con);
            }
            System.out.println("获取无参构造函数");
            Constructor con1 = clazz3.getConstructor(null);
            con1.newInstance();


            System.out.println("获取有参数构造函数名调用=============");
            Constructor con2 = clazz3.getConstructor(String.class);

            con2.newInstance("123456");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        // 获取成员变量与成员方法

        Class cl2 = Class.forName("inspur.fanshe.testclass.Student");
//        获取成员变量成员方法：这里只限为public
        System.out.println("输出成员变量成员");
        Field[] fields = cl2.getFields();
        for (Field f : fields) {
            System.out.println("输出成员变量与成员====>" + f);
        }
        fields = cl2.getDeclaredFields();
        for (Field f : fields) {
            System.out.println("输出已经声明的成员变量" + f);
        }
        System.out.println("获取共有字段并调用");
        Field ff = cl2.getField("username");
        System.out.println("输出指定的共有字段" + ff);
        Object object = cl2.getConstructor().newInstance();
        ff.set(object, "sunfengchuan");

        Student student = (Student) object;
        String usernamee = student.username;
        System.out.println(usernamee + "--------------" + student);


        Method[] methods = cl2.getMethods();
        for (Method m : methods) {
            System.out.println("这个是方法区===》" + m);
        }

        methods = cl2.getDeclaredMethods();
        for (Method mm : methods) {
            System.out.println("这个是声明的方法区====" + mm);
        }

        System.out.println("以下是获取方法的名字具体方法");

        Method method = cl2.getMethod("show");

        System.out.println("输出方法名字" + method);
        Object obj = cl2.getConstructor().newInstance();
        method.invoke(obj);

        method = cl2.getMethod("show4", String.class);
        method.invoke(obj, "江山");

        Class cl3 = Class.forName(p().getProperty("className"));

        method = cl3.getMethod((String) p().get("method"), String.class);
        System.out.println("输出的===method====" + method);


    }

    public static Properties p() throws IOException {

        Properties properties = new Properties();

        System.getProperty("java.class.path");
        ClassLoader.getSystemResource("ceshi.properties");
        FileReader fileReader = new FileReader("classpath:ceshi.properties");

        properties.load(fileReader);

        String canshu1 = properties.getProperty("className");
        System.out.println("======>>>>=======" + canshu1);
        fileReader.close();
        return properties;
    }


}
