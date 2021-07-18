package shejimoshi.BuiderModel;

/**
 * @author sunfch  这个是建造者
 * @create 2018-10-14 15:08
 * @desc 造人接口
 **/
public interface IBuidHuan {

    public void BuildBody();

    public void BuildFoot();

    public void BuildHead();

    public void BuidHand();

    public Huan creatneHuan();

}
