package leetcode.mid;

import java.util.LinkedList;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 层序遍历二叉树, 从根节点出发,
 * @date 2020/6/9 21:52
 */
public class 层序遍历二叉树 {

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(2);
        treeNode.left = new TreeNode(3);
        treeNode.left.left = new TreeNode(10);
        treeNode.right = new TreeNode(5);
        treeNode(treeNode);
    }

    public static void treeNode(TreeNode root) {

        if (root == null) {
            return;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isLeft = false;
        while (!queue.isEmpty()) {

            TreeNode pollData = queue.poll();
            System.out.println(pollData.val);
            if (pollData.left != null) {
                if (isLeft) {
                    queue.addFirst(pollData.left);
                } else {
                    queue.addLast(pollData.left);
                }
            }
            if (pollData.right != null) {
                if (isLeft) {
                    queue.addFirst(pollData.right);
                } else {
                    queue.addLast(pollData.right);
                }
            }
        }

    }


}
