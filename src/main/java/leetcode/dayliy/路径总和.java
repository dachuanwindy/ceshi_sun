package leetcode.dayliy;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 112
 * <p>
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \      \
 * 7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 * @date 2020/7/7 19:07
 */
public class 路径总和 {

    public static void main(String[] args) {
        System.out.println("路径总和");
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(6);
        boolean b = hasPathSum(treeNode, 11);
        System.out.println(b);
    }

    /**
     * @description: 路径之和 ----> 这个明显用递归能做出来
     * @author sunfch
     * @date 2020/7/7 19:09
     */
    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.right == null && root.left == null) {
            if (root.val == sum) {
                return true;
            }
            return false;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }


    /**
     * @description: 采用for循环的方式实现
     * @author sunfch
     * @date 2020/7/10 10:13
     */
    public static boolean method3(TreeNode root, int sum) {

        return false;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}