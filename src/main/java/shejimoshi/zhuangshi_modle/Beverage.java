package shejimoshi.zhuangshi_modle;

/**
 * @author sunfc
 * @description: 饮料接口, 这个接口必须有:
 * 分析: 针对单一的类进行装饰,是不需要这个类的,
 * 但是:针对某一类产品进行装饰,必须传入一个抽象的对象,来接入这个类
 * @date 2020/5/2 02:00
 */
public interface Beverage {
    String description();

    int price();
}
