package inspur.fanshe.testclass;

/**
 * @author sunfch
 * @create 2018-07-21 10:12
 * @desc 反射测试类
 **/
public class Student {

    public Student() {
        System.out.println("这个无参构造函数");
    }

    public Student(char c) {
        System.out.println("这个是有参构造函数====" + c);
    }

    public Student(String a, String b) {
        System.out.println("这个两个参数的构造函数");
    }

    public Student(String a) {
        System.out.println("这个两个参数的构造函数" + a);
    }

    public void play() {
        System.out.println("正常输出play");
    }


    public String username;


    public String lastname;

    private int age;

    @Override
    public String toString() {
        return "Student{" +
                "username='" + username + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                '}';
    }


    public void show() {
        System.out.println(" 这个是public 没有参数的show");
    }

    protected void show2() {

        System.out.println("这个是一个protected  show ");

    }

    private void show3() {

        System.out.println("这个是一个私有的show");
    }

    public void show4(String c) {
        System.out.println("这个有参数的show" + c);
    }

}
