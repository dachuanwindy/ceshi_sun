package shejimoshi.Factory_mode_2.factory_mode_abstract;

/**
 * @author sunfch
 * @create 2018-11-03 14:49
 * @desc 早餐商店买早餐
 **/
public class Breakfastshop implements  Breakfast {
    @Override
    public void sell() {
        System.out.println("买早餐了。。。。");
    }
}
