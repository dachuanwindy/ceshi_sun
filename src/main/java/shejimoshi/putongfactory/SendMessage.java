package shejimoshi.putongfactory;

public class SendMessage implements  Sender {
    @Override
    public void sender() {
        System.out.println("发送消息");
    }
}
