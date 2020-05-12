package shejimoshi.putongfactory;

public class TestMian {
    public static void main(String[] args) {
       // 单工厂模式
        SendFactory factory = new SendFactory();
        Sender sender = factory.producer("email");
        sender.sender();
        //多工厂模式测试
        DuoFactory();


    }

    // 多工厂模式测试
    public static void DuoFactory() {
        SendFactory sendFactory = new SendFactory();
        Sender senderceshi1 = sendFactory.senderEmai();
        senderceshi1.sender();

        Sender sender2 = sendFactory.senderMsg();
        sender2.sender();
    }
}
