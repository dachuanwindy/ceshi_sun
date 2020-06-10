package leetcode.mid;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 层序遍历二叉树,从根节点出发,
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
        Queue<TreeNode> queue = new LinkedBlockingDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {

            TreeNode pollData = queue.poll();
            System.out.println(pollData.val);
            if (pollData.left != null) {
                queue.add(pollData.left);
            }
            if (pollData.right != null) {
                queue.add(pollData.right);
            }
        }

    }


}
