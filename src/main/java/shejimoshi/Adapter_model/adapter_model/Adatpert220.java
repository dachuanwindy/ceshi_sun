package shejimoshi.Adapter_model.adapter_model;

/**
 * @author sunfch
 * @create 2018-11-04 12:29
 * @desc
 **/
public class Adatpert220 extends PowerPort220 implements Target {
     //继承+实现 这个是适配器模式的关键所在，

    @Override
    public void converTo_110V() {
        // 这里只需源输入的变量，然后进行业务转换，给我220V，我用coverto110V进行相关操作
        this.output220();
    }
}
