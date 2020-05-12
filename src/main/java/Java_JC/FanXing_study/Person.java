package Java_JC.FanXing_study;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Person {

    public Person() {
    }

    private String name;
    private int age;
    private String gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}


class reflect_demo {

    public reflect_demo() {

        try {

            /**
             * @Description: 这个已经实例化了数据
             * @Author: sunfch
             * @Date: 2019/2/20-17:33
             * @Param: []
             * @Return:
             */
            Class clazz = Class.forName("Java_JC.FanXing_study.Person");



            //获取方法
            Method[] methods = clazz.getMethods();
            for (Method m : methods) {
                System.out.println(m);
            }


            Field[] fields = clazz.getDeclaredFields();
            System.out.println("field 输出 。。。。");
            for (Field f : fields) {
                System.out.println(f);
            }

            System.out.println("Constructors。。。。");
            Constructor[] constructor = clazz.getDeclaredConstructors();
            for (Constructor constructor1 : constructor) {

                System.out.println(constructor1);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}

class Test_main {

    public static void main(String[] args) {
        System.out.println("反射输出。。。。");

        reflect_demo reflect_demo = new reflect_demo();

        try {
            Class aClass = Class.forName("Java_JC.FanXing_study.Person");
            Person person = (Person) aClass.newInstance();
            person.setAge(12);
            int age = person.getAge();
            System.out.println(age + "     >>>>>>>");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}