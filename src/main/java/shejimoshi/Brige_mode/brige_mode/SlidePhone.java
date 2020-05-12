package shejimoshi.Brige_mode.brige_mode;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 滑盖手机实现的功能
 * @date 2020/5/1 19:06
 */
public class SlidePhone extends Phone {
    SlidePhone(PhoneFunction function) {
        super(function);
    }

    @Override
    public void call() {
        super.call();
        System.out.println("折叠手机实现打电话");
    }


}
