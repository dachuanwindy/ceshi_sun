import java.util.LinkedList;

/**
 * @author sunfch
 * @description: TODO
 * @date 2020/7/29 14:54
 */
public class MyTest2 {

    public static void main(String[] args) {

        double v = sqrt2(8);
        System.out.println(v);

        LinkedList<Object> objects = new LinkedList<>();
        objects.add("");
    }

   static double EPSILON = 0.0000000001;

   static double sqrt2( double value) {
        double low = 0, high = value;
        double mid = (low + high) / 2;

        while (high - low > EPSILON) {
            if (mid * mid > value) {
                high = mid;
            } else {
                low = mid;
            }
            mid = (high + low) / 2;
        }

        return mid;
    }
}