package leetcode.专项.二叉树;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 107. 二叉树的层次遍历 II
 * 102. 二叉树的层序遍历
 * @date 2020/7/16 16:40
 */
public class 二叉树层序遍历 {
    public static void main(String[] args) {

        HashMap<Object, Object> map = new HashMap<>();
        map.put("","");
        System.out.println("层序遍历输出");
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.left.left = new TreeNode(12);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> list = levelOrderBottom(root);
        System.out.println(list.toString());

    }


    /**
     * @description: 层序遍历二叉树
     * 技术总结:
     * 1.层序遍历,就是一层一层的输出;怎么保证一层输出? 广度搜素---BSF---->技术是queue实现;
     *
     * @author sunfch
     * @date 2020/7/25 22:51
     */
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> list = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            LinkedList<TreeNode> tempList = new LinkedList<>();
            ArrayList<Integer> innerList = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode poll = queue.poll();
                innerList.add(poll.value);
                if (poll.left != null) {
                    tempList.add(poll.left);
                }
                if (poll.right != null) {
                    tempList.add(poll.right);
                }
            }
            list.add(innerList);
            queue = tempList;
        }
        System.out.println(list.toString());
        return list;
    }
}
