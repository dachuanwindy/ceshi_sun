package shejimoshi.state_Mode;

public class Context {

    //引用state 类
    private State state;

    // 上下文中，参数是state类。然后根据state类去实现方法切换。
    public Context(State state) {
        this.state = state;
    }
    public State getState() {
        return state;
    }
    public void setState(State state) {
        this.state = state;
    }


    public void method() {
        if (state.getValue().equals("state1")) {
            state.method1();
        }
        if (state.getValue().equals("state2")) {
            state.method2();
        }

    }

}
