package shejimoshi.zhuangshi_modle;

/**
 * @author sunfch
 * @create 2018-10-14 9:41
 * @desc 咖啡实现接口
 **/
public class Coffee implements Beverage {

    private String description = "咖啡实现";

    @Override
    public String description() {
        return description;
    }

    @Override
    public int price() {
        return 50;
    }
}
