package leetcode.专项.二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunfch
 * @version V1.0
 * @Description: TODO
 * @date 2020/7/15 16:26
 */
public class 判断是否为二叉搜索树 {

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(4);
        treeNode.right = new TreeNode(8);
        treeNode.left.left = new TreeNode(3);
        ArrayList<Integer> integers = new ArrayList<>();
        MidOut(treeNode, integers);
        System.out.println(integers);

        //判断是否为搜索二叉树,还需要
        boolean bst = isBST(treeNode);
        System.out.println(bst);
    }

    /**
     * @description: 判断是否为二叉搜索树
     * @author sunfch
     * @date 2020/7/15 16:27
     */
    public static boolean isBST(TreeNode root) {

        // 中序遍历输出,判断是否有序就可以;
        ArrayList<Integer> integers = new ArrayList<>();
        MidOut(root, integers);
        for (int i = 1; i < integers.size(); i++) {
            if (integers.get(i - 1) > integers.get(i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * @description:
     * @author sunfch
     * @date 2020/7/16 12:01
     */
    public static void MidOut(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            MidOut(root.left, list);
        }
        list.add(root.value);
        System.out.println(root.value);
        if (root.right != null) {
            MidOut(root.right, list);
        }
    }
}
