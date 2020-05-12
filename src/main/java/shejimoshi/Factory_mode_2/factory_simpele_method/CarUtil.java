package shejimoshi.Factory_mode_2.factory_simpele_method;

/**
 * @author sunfch
 * @create 2018-11-03 10:58
 * @desc 选车工具
 **/
public  class CarUtil {



    public Car cartype(int i) {
        if (i == 1) {
            return new Car_jeep();
        }
        if (i == 2) {
            return new Benchi();
        }
        return null;
    }


    public static void main(String[] args) {
        CarUtil carUtil = new CarUtil();
        carUtil.cartype(3).driver();
    }
}
