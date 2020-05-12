package YWSJ.GNSJ;

/**
 * @author sunfch
 * @create 2018-03-25 8:38
 * @desc 订单系统模型
 **/
public class Dingdan {

    private String id;

    private String GoodsName;

    private String Goodprice;

    private int GoodsNumber;

    private int GoodsToal;

    //骑手id
    private String QsId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGoodsName() {
        return GoodsName;
    }

    public void setGoodsName(String goodsName) {
        GoodsName = goodsName;
    }

    public String getGoodprice() {
        return Goodprice;
    }

    public void setGoodprice(String goodprice) {
        Goodprice = goodprice;
    }

    public int getGoodsNumber() {
        return GoodsNumber;
    }

    public void setGoodsNumber(int goodsNumber) {
        GoodsNumber = goodsNumber;
    }

    public int getGoodsToal() {
        return GoodsToal;
    }

    public void setGoodsToal(int goodsToal) {
        GoodsToal = goodsToal;
    }

    public String getQsId() {
        return QsId;
    }

    public void setQsId(String qsId) {

        QsId = qsId;
    }





}
