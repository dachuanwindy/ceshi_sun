package leetcode.专项.二叉树;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 输出第K层节点
 * @date 2020/7/16 12:14
 */
public class 第K层节点个数 {

    public static void main(String[] args) {
        System.out.println("输出第K层节点个数");
    }


    public static int TreeNodeK(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        int left = TreeNodeK(root.left, k - 1);
        int right = TreeNodeK(root.right, k - 1);
        return left + right;

    }

}
