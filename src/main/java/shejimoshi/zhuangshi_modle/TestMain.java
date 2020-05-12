package shejimoshi.zhuangshi_modle;

/**
 * @author sunfch
 * @create 2018-10-14 11:30
 * @desc 设计模式测试
 **/
public class TestMain {

    public static void main(String[] args) {
        //单品咖啡
        Beverage beverage = new Coffee();
        //对单品咖啡进行装饰,可以根据情况添加牛奶,添加摩卡
        beverage = new Milk(beverage);
        beverage = new Moka(beverage);
        System.out.println(beverage.description());
    }
}
