package leetcode.专项.二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sunfch
 * @version V1.0
 * @Description: TODO
 * @date 2020/7/16 15:30
 */
public class 二叉树层的平均值 {
    public static void main(String[] args) {
        System.out.println("二叉树层的平均值");
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<Double> doubles = averageOfLevels(root);
        System.out.println(doubles);

    }

    /**
     * @description: 每一次层的平均值---->
     * 第一:用到了广度搜索;
     * 第二:把第二层的值完全放入的一个新的队列中; 层序输出,可以将队列反转.出现新的输出方式了.
     * 第三: 每层的平均值,或者每一层的数量,这个可以实现的.
     * @author sunfch
     * @date 2020/7/16 16:23
     */
    public static List<Double> averageOfLevels(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<Double> doubles = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            double sum = 0;
            double count = 0;
            LinkedList<TreeNode> innerQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode temp = queue.pop();
                sum += temp.value;
                count++;
                if (temp.left != null) {
                    innerQueue.add(temp.left);
                }
                if (temp.right != null) {
                    innerQueue.add(temp.right);
                }
            }
            queue = innerQueue;
            doubles.add(sum * 1.0 / count);
        }
        return doubles;
    }

}
