package leetcode.专项.二叉树;

import java.util.LinkedList;

/**
 * @author sunfch
 * @version V1.0
 * @Description: TODO
 * @date 2020/7/26 09:31
 */
public class 判断两个树是否相等 {


    public static void main(String[] args) {

    }

    /**
     * @description: 判断树是否相等
     * @author sunfch
     * @date 2020/7/26 09:32
     */
    public static boolean isEqualTree(TreeNode t1, TreeNode t2) {

        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        if (t1.value == t2.value) {
            return true;
        }
        return isEqualTree(t1.left, t2.left) && isEqualTree(t1.right, t2.right);
    }

    /**
     * @description: 通过树迭代实现; 这地方其实就用到了queue;
     * @author sunfch
     * @date 2020/7/26 09:38
     */
    public static boolean isTreeEqual(TreeNode t1, TreeNode t2) {

        LinkedList<TreeNode> t1Queue = new LinkedList<>();
        LinkedList<TreeNode> t2Queue = new LinkedList<>();
        t1Queue.add(t1);
        t2Queue.add(t2);
        while (!t1Queue.isEmpty() && !t2Queue.isEmpty()) {
            TreeNode t1Node = t1Queue.pop();
            TreeNode t2Node = t2Queue.pop();

            if (!isCheck(t1Node, t2Node)) {
                return false;
            }
            if (t1.left != null) {

            }
        }
        return false;
    }

    private static boolean isCheck(TreeNode t1, TreeNode t2) {

        if (t1 != null && t2 != null) {
            return true;
        }
        if (t1 != null || t2 != null) {
            return false;
        }
        if (t1.value == t2.value) {
            return true;
        }
        return false;
    }
}
