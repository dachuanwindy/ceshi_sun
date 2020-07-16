package leetcode.专项.二叉树;

import java.util.LinkedList;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 这是一道简单题, 而我不会
 * @date 2020/7/16 09:34
 */
public class 反转二叉树 {

    public static void main(String[] args) {
        System.out.println("简单题,反转二叉树");

        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(5);
        treeNode.right = new TreeNode(6);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(10);
//        TreeNode treeNode1 = inverterTree(treeNode);
//        System.out.println(treeNode1);


        TreeNode treeNode2 = inverterTree2(treeNode);
        System.out.println(treeNode2);
    }

    /**
     * @description: 反转二叉树, 这个考的可能性不大
     * 技术总结:
     * 通过递归方式容易实现:
     * 1.将左右节点反转,然后递归下去,
     * 2,递归终止条件:
     * @author sunfch
     * @date 2020/7/16 09:37
     */
    public static TreeNode inverterTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        inverterTree(root.left);
        inverterTree(root.right);
        return root;
    }


    /**
     * @description: 迭代实现反转
     * 迭代实现反转技术总结:
     * 1.迭代方式采用了广度遍历的方式,
     * 2.左右节点互换, 然后将新的新的节点重新放入队列中进行消费;
     * @author sunfch
     * @date 2020/7/16 10:01
     */
    public static TreeNode inverterTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            TreeNode left = temp.left;
            temp.left = temp.right;
            temp.right = left;
            // 左节点不为空,就将左节点,让进去
            if (temp.left != null) {
                queue.add(temp.left);
            }
            //左节点不为空,就将左节点,让进去
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
        return root;
    }
}

