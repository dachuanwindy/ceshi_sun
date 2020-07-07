package leetcode.专项.二叉树;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 通过递归实现, 二叉搜索树的特点是:
 * @date 2020/7/7 17:34
 */
public class 排序数组转成二叉搜索树 {


    public static void main(String[] args) {
        System.out.println("将排序好的数组,转成二叉搜索树");

        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        TreeNode treeNode = buildTree(arr, 0, 6);
        System.out.println(treeNode);
    }

    /**
     * @description: 将结果转成二叉搜索树
     * @author sunfch
     * @date 2020/7/7 17:49
     */
    public static TreeNode buildTree(int[] arr, int left, int right) {
        if (right - left < 1) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode treeNode = new TreeNode(arr[mid]);
        treeNode.left = buildTree(arr, left, mid);
        treeNode.right = buildTree(arr, mid + 1, right);
        return treeNode;
    }

}
