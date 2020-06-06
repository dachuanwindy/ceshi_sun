package leetcode.hard;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 头条 相邻孩子分糖果
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 * <p>
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 * <p>
 * 每个孩子至少分配到 1 个糖果。
 * 相邻的孩子中，评分高的孩子必须获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 */
public class 相邻孩子分糖果 {
    public static void main(String[] args) {

        int[] arr = {2, 1};

        int method = method(arr);
        System.out.println(method);
    }

    //贪心算法
    public static int method(int[] ratings) {

        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];

        left[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i - 1] < ratings[i]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }
        right[ratings.length - 1] = 1;
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            } else {
                right[i] = 1;
            }
        }
        int count = 0;
        for (int i = 0; i < ratings.length; i++) {
            int max = Math.max(left[i], right[i]);
            count = count + max;
        }
        return count;
    }
}
