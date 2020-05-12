package shejimoshi.Brige_mode.brige_mode;

/**
 * @author sunfch
 * @version V1.0
 * @Description: TODO
 * @date 2020/5/1 18:56
 */
public class HuaWeiPhone implements PhoneFunction {

    /**
     * description: 打电话
     *
     * @return void
     */
    @Override
    public void call() {
        System.out.println("华为手机打电话");
     }

    /**
     * description: 发短信
     *
     * @return void
     */
    @Override
    public void sendMsg() {
        System.out.println("华为手机发短息");
    }

    /**
     * description: 关机
     *
     * @return void
     */
    @Override
    public void closePhone() {
        System.out.println("华为手机关机");
    }
}
