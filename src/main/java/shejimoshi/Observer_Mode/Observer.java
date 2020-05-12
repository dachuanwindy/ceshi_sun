package shejimoshi.Observer_Mode;

//
public interface Observer {
    public void update();
}

class oberver1 implements Observer {
    @Override
    public void update() {
        System.out.println("oberver1 收到更改");
    }
}

class oberver2 implements Observer {
    @Override
    public void update() {
        System.out.println("oberver2 收到更改");
    }
}
