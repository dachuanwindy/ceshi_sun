package leetcode.专项.二叉树;


/**
 * @author sunfch
 * @version V1.0
 * @Description: 数组还原树, 通过 前序排列和中序排列
 * @date 2020/7/5 07:53
 */
public class 数组还原二叉树 {


    public static void main(String[] args) {
        System.out.println("输出参数====");

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9,10};
    }

    /**
     * @description: 通过递归实现
     * @author sunfch
     * @date 2020/7/5 08:00
     * <p>
     * <p>
     * 二叉树 前序遍历:===={根 [左]||界限||[右边]}
     * 二叉树 中序遍历:==== [左]||中||[右边]
     */
    public static TreeNode buildTree(int[] pre, int pre_start, int pre_end, int[] inner, int inner_start, int inner_end) {
        if (pre_start == pre_end) {
            return null;
        }
        int rootValue = pre[pre_start];
        TreeNode root = new TreeNode(rootValue);
        // 找到中间值
        int mid_index = 0;
        for (int i = 0; i < inner.length; i++) {
            if (rootValue == inner[i]) {
                mid_index = i;
            }
        }
        root.left = buildTree(pre, pre_start + 1, pre_start + mid_index + 1, inner, inner_start, mid_index);
        root.right = buildTree(pre, pre_start + mid_index + 1, pre_end, inner, mid_index, inner_end);
        return root;
    }


    /**
     * @description: 通过迭代实现, 就是通过栈来实现
     * @author sunfch
     * @date 2020/7/5 08:16
     */
    public static TreeNode buildTree2(int[] pre, int[] inner) {
        return null;
    }

}


final class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int value) {
        this.value = value;
    }
}