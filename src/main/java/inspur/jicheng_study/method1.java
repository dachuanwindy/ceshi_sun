package inspur.jicheng_study;

public class method1 {
    public String ceshi1 = "我是父类中的一个方法";

    public method1() {

        this.toString();
    }

    public void ceshi1() {
        System.out.println("测试方法1");
    }

    public String ceshi2(String name) {

        return "sunfengchuan ";
    }


    public String ceshi3() {
        System.out.println("父类中方法的前奏");
        return "父类中的方法";
    }

    protected String ceshi4() {
        System.out.println("测试4");
        return "ceshi4";
    }

    public String ceshi3(String aa, String bb) {
        return null;
    }

    public String ceshi3(String aa, String bb, String cc) {

        return aa + bb + cc;
    }
}
