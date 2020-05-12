package shejimoshi.zhuangshi_modle;

/**
 * @author sunfch
 * @create 2018-10-14 9:41
 * @desc 迪卡侬咖啡
 **/
public class Decathlon implements Beverage {

    private String description = "迪卡侬咖啡";

    @Override
    public String description() {
        return description;
    }

    @Override
    public int price() {
        return 50;
    }
}
