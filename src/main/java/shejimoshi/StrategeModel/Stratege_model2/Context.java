package shejimoshi.StrategeModel.Stratege_model2;

/**
 * @author sunfch
 * @create 2018-11-18 17:46
 * @desc 策略环境，策略选择中间点
 **/
public class Context {

    private Stratege stratege;

    public Context(Stratege stratege) {
        this.stratege = stratege;
    }

    public void stratege() {
        this.stratege.entry();// 输出加密方式；
    }
}
