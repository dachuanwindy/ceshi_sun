package shejimoshi.zhuangshi_modle;

/**
 * @author sunfch
 * @create 2018-10-14 10:42
 * @desc
 **/
public class Milk extends Detector {

    private String description = "加了牛奶";

    private Beverage beverage = null;

    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }


    @Override
    public String description() {
        return beverage.description() + description;
    }

    @Override
    public int price() {
        return beverage.price() + 20;
    }
}
