package shejimoshi.state_Mode;

public class State {

    //状态值
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    public void method1() {
        System.out.println("这个是状态值1");
    }

    public void method2() {
        System.out.println("这个是方法2");
    }

}
