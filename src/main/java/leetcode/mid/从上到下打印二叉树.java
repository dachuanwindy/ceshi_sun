package leetcode.mid;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * [3,9,20,15,7]
 * @date 2020/6/6 12:58
 */
public class 从上到下打印二叉树 {

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(12);
        treeNode.right = new TreeNode(4);
        treeNode.right.left = new TreeNode(5);
        int[] intS = levelOrder(treeNode);
        System.out.println(intS);
    }

    public static int[] levelOrder(TreeNode root) {

        // 什么都不输入的情况下
        if (root == null) {
            int[] ints = new int[1];
            return ints;
        }
        List<Integer> result = new ArrayList<>();
        // 队列的巧妙之处: 将输入的节点
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            result.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        int[] arr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            arr[i] = result.get(i);
        }
        return arr;
    }
}
