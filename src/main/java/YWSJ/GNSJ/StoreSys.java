package YWSJ.GNSJ;

/**
 * @author sunfch
 * @create 2018-03-25 9:56
 * @desc 商店子系统
 **/
public class StoreSys {

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public int getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(int goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public StoreSys getStoreSys() {
        return storeSys;
    }

    public void setStoreSys(StoreSys storeSys) {
        this.storeSys = storeSys;
    }

    private  String goodsName;


    private  int goodsPrice;

    private  StoreSys storeSys;





}
