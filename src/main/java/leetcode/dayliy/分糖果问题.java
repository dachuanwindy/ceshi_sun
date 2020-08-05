package leetcode.dayliy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 每日一练 :
 * @date 2020/6/1 20:46
 */
public class 分糖果问题 {

    public static void main(String[] args) {

        int[] arr = {2, 3, 5, 1, 3};
        List<Boolean> booleans = kidsWithCandies(arr, 3);
        System.out.println(booleans.toString());

    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        List<Boolean> result = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < candies.length; i++) {
            max = candies[i] > max ? candies[i] : max;
        }

        for (int i = 0; i < candies.length; i++) {
            result.add(candies[i] + extraCandies >= max);
        }
        return result;
    }
}
