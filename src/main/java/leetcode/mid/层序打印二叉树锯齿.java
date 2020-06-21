package leetcode.mid;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回锯齿形层次遍历如下：
 * <p>
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/6/20 04:50
 */
public class 层序打印二叉树锯齿 {

    public static void main(String[] args) {
        System.out.println("锯齿打印二叉树");

        TreeNode treeNode = new TreeNode(2);
        treeNode.left = new TreeNode(3);
        treeNode.right = new TreeNode(5);
        treeNode.left.left = new TreeNode(10);
        treeNode.right.right =new TreeNode(30);

        List<List<Integer>> lists = zigzagLevelOrder(treeNode);
        System.out.println(lists.toString());
    }

    /**
     * @description: 层序打印二叉树
     * @author sunfch
     * @date 2020/6/20 04:52
     */
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return null;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> arrayLists = new ArrayList<>();
        LinkedList<Integer> lever_list = new LinkedList<>();
        queue.addLast(root);
        queue.addLast(null);
        boolean isLeftToRight = false;
        while (queue.size() > 0) {
            TreeNode poll = queue.pollFirst();
            //不等于 null 说明还不需要换行
            if (poll != null) {
                System.out.println(poll.val);
                // 添加数据到结果集,
                if (isLeftToRight == true) {
                    lever_list.addFirst(poll.val);
                } else {
                    lever_list.addLast(poll.val);
                }
                //添加数据到队列,能够正常运转
                if (poll.left != null) {
                    queue.addLast(poll.left);
                }
                if (poll.right != null) {
                    queue.addLast(poll.right);
                }
            } else {
                //add  lever_list to result;
                arrayLists.add(lever_list);
                lever_list = new LinkedList<>();
                //反转lever的 遍历顺序
                if (queue.size() > 0) {
                    queue.addLast(null);
                    isLeftToRight = !isLeftToRight;
                }
            }
        }
        return arrayLists;
    }
}
