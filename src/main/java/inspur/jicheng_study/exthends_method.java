package inspur.jicheng_study;

public class exthends_method extends method1 {
    private String name = "hello,大家好！";

    public exthends_method() {


        this.name = name;
    }

    public static void main(String[] args) {
        String str = "dfdfdfdfdfdf";
        System.out.println("能正常输出");
        exthends_method ex = new exthends_method();
        method1 md1 = new method1();
        md1.ceshi4();
        System.out.println(" protect 测试实例");
        md1.ceshi3();
        String fuleifangfang = ex.ceshi2(str);


        String out = ex.ceshi3("aaa", "ccc", "bbb");

        System.out.println("这次要输出的格式是构造函数" + out);


    }

    @Override
    public String ceshi2(String name) {
        System.out.println("--我是对父类方法的重写--");
        super.ceshi1();

        return "--父类方法的重写";
    }
}
