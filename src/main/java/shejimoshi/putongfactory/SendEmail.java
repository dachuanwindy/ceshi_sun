package shejimoshi.putongfactory;

public class SendEmail implements Sender {
    @Override
    public void sender() {
        System.out.println("发送邮件");
    }
}
