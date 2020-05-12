package inspur.interface_impl;

import java.util.Map;

public class interface_impl extends extends_interface {
    @Override
    public String eat_mantou(String mianfen) {
        return null;
    }

    @Override
    public String eat_zhaji(String money, String shopping) {

        if (money == null && shopping == null) {
            System.out.println("你现在不能吃炸鸡");
            return "你不能吃炸鸡";
        } else return "可以吃炸鸡了";
    }

    @Override
    public Map eat_huotui() {
        return null;
    }

    @Override
    public String eat_humberger() {
        return null;
    }
}
