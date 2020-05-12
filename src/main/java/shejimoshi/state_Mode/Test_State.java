package shejimoshi.state_Mode;
/*
 * 状态模式：当状态发生改变时，可以同事改变对象的行为。这就是状态模式的核心思想。比如QQ 上下线；
 * 应用场景：互联网功能权限设计的时候，可以考虑用状态模式进行设计。
 *  状态模式只是：类与类之间的关系，没有设计到接口，
 *
 *  第一步: 建立一个类，编写自己的方法 method1，method2.....， 其中方法对外提供一个接收状态值的方法，这就是 private string value;
 *
 *  第二步：编写上下文类（这个类是自己随便写的，其中里面有 引用state类，
 *  其目的是可以根据state.getvalue.equals("state1"),实现对state方法的引用） 引用state类， 上下文
 *
 *
 *
 *
 */

public class Test_State {
    public static void main(String[] args) {
        State state = new State();
        Context context = new Context(state);
        state.setValue("state1");
        context.method();
        state.setValue("state2");
        context.method();
    }
}
