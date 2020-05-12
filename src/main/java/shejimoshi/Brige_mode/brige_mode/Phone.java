package shejimoshi.Brige_mode.brige_mode;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 手机抽象类, 实现桥接就是通过这个抽象类实现的桥接
 * @date 2020/5/1 18:59
 */
public abstract class Phone {

    private PhoneFunction function;

    Phone(PhoneFunction function) {
        this.function = function;
    }

    public void close() {
        this.function.closePhone();
    }

    public void call() {
        this.function.call();

    }

    /**
     * description: 抽象类中调用传入品牌手机发短信的接口
     *
     * @param
     * @return void
     */
    public void sendMsg() {
        this.function.sendMsg();
    }
}
