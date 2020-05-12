package shejimoshi.Proxy_moshi;

public class Proxy implements Soucerbale {

    private Source source;  // 原始实现的方法，在此方法中被引用到

    //代理构造方法，引用父类，然后
    public Proxy() {
        super();
        this.source = new Source();
    }

    //代理重写方法，
    @Override
    public void method1() {
        before();
        System.out.println("这个是代理实现的方法===");
        after();
    }

    // 我理解这就是AOP模式的原型吧
    public void before() {
        System.out.println("调用代理之前：  before  proxy");
    }

    public void after() {
        System.out.println(" 调用代理之后： after proxy");
    }
}
