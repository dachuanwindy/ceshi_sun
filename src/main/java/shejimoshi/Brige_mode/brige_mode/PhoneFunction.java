package shejimoshi.Brige_mode.brige_mode;

/**
 * DESC:手机功能:每个手机都有的 打电话,发短信 关机,开机
 *
 * @author :Brand
 * @date 2020/5/1-18:52
 */

public interface PhoneFunction {


    /**
     * description: 打电话
     *
     * @param
     * @return void
     */
    void call();

    /**
     * description: 发短信
     *
     * @param
     * @return void
     */
    void sendMsg();

    /**
     * description: 关机
     *
     * @param
     * @return void
     */
    void closePhone();
}
