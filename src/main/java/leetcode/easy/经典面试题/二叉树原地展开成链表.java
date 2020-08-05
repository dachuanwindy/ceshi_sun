package leetcode.easy.经典面试题;


import lombok.SneakyThrows;

import java.util.Stack;
import java.util.concurrent.*;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 二叉树原地展开成链表,
 * @date 2020/5/23 16:39
 */
public class 二叉树原地展开成链表 {

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        System.out.println("二叉树原地展开成链表");

        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(4);
        treeNode.right = new TreeNode(5);
        treeNode.right.right = new TreeNode(6);

        TreeNode method = method(treeNode);
        System.out.println(method.toString());


        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println("就是这么实现的");
            }
        });

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5, 10, 5, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));

        for (int i = 0; i < 6; i++) {
            poolExecutor.execute(new Runnable() {
                @SneakyThrows
                @Override
                public void run() {
                    System.out.println("任务执行完成1.");
                    cyclicBarrier.await();
                }
            });
        }


    }

    /**
     * @description: 二叉树原地展开成链表, 而且树链表
     * 技术总结:
     * 1.这个是采用迭代的方式实现调用的;
     * @author sunfch
     * @date 2020/7/30 19:05
     */
    public static TreeNode method(TreeNode root) {

        if (root == null) {
            return null;
        }
        TreeNode pre = null;
        Stack<TreeNode> stack = new Stack();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            if (pre != null) {
                pre.right = temp.left;
                pre.left = null;
            }
            if (temp.right != null) {
                stack.add(temp.right);
            }
            if (temp.left != null) {
                stack.add(temp.left);
            }
            pre = temp;
        }
        return pre;
    }
}

