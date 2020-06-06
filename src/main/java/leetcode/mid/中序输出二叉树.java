package leetcode.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 中序遍历二叉树
 * @date 2020/6/6 07:54
 */
public class 中序输出二叉树 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.right = new TreeNode(4);
        treeNode.right.left = new TreeNode(5);

        List<Integer> integers = inorderTraversal(treeNode);
        System.out.println(integers);

    }

    static List<Integer> result = new ArrayList<>();

    public static List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return result;
        }
        inorderTraversal(root.left);
        result.add(root.val);
        inorderTraversal(root.right);
        return result;
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
