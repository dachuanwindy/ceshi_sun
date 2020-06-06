package leetcode.easy.soeasy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 输出二叉树的单节点
 * <p>
 * 二叉树肯定用递归来实现
 * @date 2020/6/6 06:35
 */
public class 树的节点 {
    public static void main(String[] args) {
        System.out.println("二叉树的单节点个数");

        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.left.left = new TreeNode(5);
        List<Integer> lonelyNodes = getLonelyNodes(treeNode);
        System.out.println(lonelyNodes.toString());

    }

    static List<Integer> result = new ArrayList<>();

    public static List<Integer> getLonelyNodes(TreeNode root) {
        if (root == null) {
            return result;
        }
        if (root.left == null && root.right != null) {
            result.add(root.right.val);
            return result;
        }
        if (root.left != null && root.right == null) {
            result.add(root.left.val);
        }
        getLonelyNodes(root.right);
        getLonelyNodes(root.left);
        return result;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
