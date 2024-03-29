package leetcode.easy.经典面试题;

import lombok.Data;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 二叉树
 * @date 2020/5/24 09:21
 */
@Data
public class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int value) {
        this.value = value;
    }

}
