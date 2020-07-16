package leetcode.专项.二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 实现中序遍历, 两种方式:递归, while循环
 * @date 2020/7/11 11:45
 */
public class 中序遍历二叉树 {


    public static void main(String[] args) {
        System.out.println("中序遍历二叉树");
        //方式1 利用递归实现;
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(3);
        treeNode.right = new TreeNode(6);
        treeNode.right.left = new TreeNode(9);
        List<Integer> result = new ArrayList<>();
        method(treeNode, result);
        System.out.println(result.toString());


        // 迭代的方式实现

        method2(treeNode, result);
        System.out.println(result);

    }

    /**
     * @description: 通过递归方式实现
     * @author sunfch
     * @date 2020/7/11 11:49
     */
    public static void method(TreeNode root, List<Integer> result) {
        if (root != null) {
            if (root.left != null) {
                method(root.left, result);
            }
            result.add(root.value);
            System.out.println(root.value);
            if (root.right != null) {
                method(root.right, result);
            }
        }
    }

    /**
     * @description: 方式2
     * @author sunfch
     * @date 2020/7/11 11:52
     */
    public static void method2(TreeNode root, List<Integer> result) {
        // 声明一个栈,  这个栈的意思就是递归每次存放的值;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root.left != null) {
                stack.push(root.left);
                root = root.left;
            }
            TreeNode pop = stack.pop();
            result.add(pop.value);
            root = root.right;
        }
    }
}
