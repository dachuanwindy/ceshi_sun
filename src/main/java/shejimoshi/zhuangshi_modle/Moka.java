package shejimoshi.zhuangshi_modle;

/**
 * @author sunfch
 * @create 2018-10-14 10:42
 * @desc 咖啡作料, 可以加糖,可以加牛奶,也可以加摩卡
 **/
public class Moka extends Detector {

    private String description = "加了摩卡";

    private Beverage beverage = null;

    public Moka(Beverage beverage) {
        this.beverage = beverage;
    }


    @Override
    public String description() {
        return beverage.description() + description;
    }

    @Override
    public int price() {
        return beverage.price() + 50;
    }
}
