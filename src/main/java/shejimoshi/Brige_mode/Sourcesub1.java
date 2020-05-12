package shejimoshi.Brige_mode;

public class Sourcesub1 implements Sourceable {

    @Override
    public void method() {
        System.out.println("子应用=1=实现接口方法");
    }
}

class Sourcesub2 implements  Sourceable{
    @Override
    public void method() {
        System.out.println("子应用=2=实现接口方法");
    }
}