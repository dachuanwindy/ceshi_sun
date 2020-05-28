package leetcode.easy.niuke;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 数组判读盛水容器最大
 * @date 2020/5/28 21:03
 */
public class 盛水容器最大 {

    public static void main(String[] args) {
        System.out.println("盛水容器最大解决方案");

        int[] arr = new int[]{3, 10, 3};
        int i = method2(arr);
        System.out.println("最多盛水" + i);

    }

    /**
     * description: 采用暴力解决方案
     *
     * @param height
     * @return void
     */
    public static int method1(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = 1; j < height.length; j++) {
                int max = min(height[i], height[height.length - j]);
                int value = max * (height.length - i - j);
                maxArea = max(value, maxArea);
            }
        }
        return maxArea;
    }

    static int max(int a, int b) {
        if (a >= b) {
            return a;
        }
        return b;
    }

    static int min(int a, int b) {
        if (a >= b) {
            return b;
        }
        return a;
    }

    /**
     * description: 双指针解决问题
     *
     * @param height
     * @return int
     */
    public static int method2(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length;
        while (left < right) {
            int minvlue = min(height[left], height[right - 1]);
            int value = minvlue * (right - left - 1);
            maxArea = max(maxArea, value);
            if (height[left] == minvlue) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;

    }
}
