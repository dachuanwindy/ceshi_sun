package shejimoshi.zhuangshi_modle;

/**
 * @author sunfch
 * @create 2018-10-14 9:43
 * @desc 装饰器: 可以是一个类,  也可以是一个抽象类, 但不可以是一个借口
 * <p>
 * 注意: 这个地方用到的是实现原接口,
 **/
public class Detector implements Beverage {

    @Override
    public String description() {
        String decription = "装饰模式实现，这只是装饰模式。。";
        return decription;
    }

    @Override
    public int price() {
        return 0;
    }
}
