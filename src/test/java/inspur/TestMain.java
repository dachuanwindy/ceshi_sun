package inspur;

/**
 * /**
 *
 * @author sunfch
 * @create 2018-12-10 11:44
 * @desc 测试岗位
 **/
public class TestMain {

    public static void main(String[] args) {


    }
}

interface Sender {
    void send();
}

class Msg implements Sender {
    @Override
    public void send() {
        System.out.println("发短信");
    }
}

class Email implements Sender {
    @Override
    public void send() {
        System.out.println("发送Email");
    }
}

interface Provider {
    Sender providerMethod();
}

class MailFactory implements Provider {
    @Override
    public Sender providerMethod() {
        return new Email();
    }
}

class MsgFactory implements Provider {
    @Override
    public Sender providerMethod() {
        return new Msg();
    }
}

//抽象工厂 : provider