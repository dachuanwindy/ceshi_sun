package shejimoshi.putongfactory;

public class SendFactory {

    public Sender producer(String type) {
        if ("email".equals(type)) {
            return new SendEmail();
        } else if ("msg".equals(type)) {
            return new SendMessage();
        }

        return null;
    }

    //多工厂模式

    public Sender senderEmai() {

        return new SendEmail();
    }

    public Sender senderMsg() {
        return new SendMessage();
    }
}
