package shejimoshi.Factory_mode_2.factory_mode_abstract;

/**
 * @author sunfch
 * @create 2018-11-03 14:51
 * @desc 便宜的早餐店麦早餐
 **/
public class BunsBreakFastshop extends Breakfastshop {

    @Override
    public void  sell(){
        System.out.println("这里的包子只需要1.5元");
    }
}


