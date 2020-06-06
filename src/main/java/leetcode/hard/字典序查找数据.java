package leetcode.hard;

/**
 * @author sunfch
 * @version V1.0
 * @Description:
 * @date 2020/6/3 15:50
 */
public class 字典序查找数据 {

    public static void main(String[] args) {
        int kthNumber = findKthNumber(120, 13);
        System.out.println(kthNumber);
    }

    public static int findKthNumber(int n, int k) {

        int cur = 1;
        //扣除掉第一个0节点
        k = k - 1;
        while (k > 0) {
            int num = getNode(n, cur, cur + 1);
            //第k个数不在以cur为根节点的树上
            if (num <= k) {
                //cur在字典序数组中从左往右移动
                cur += 1;
                k -= num;
            } else {
                //在子树中
                //cur在字典序数组中从上往下移动
                cur *= 10;
                //刨除根节点
                k -= 1;
            }
        }
        return cur;
    }

    public static int getNode(int n, long first, long last) {
        int num = 0;
        while (first <= n) {
            num += Math.min(n + 1, last) - first;
            //比如n是195的情况195到100有96个数
            first *= 10;
            last *= 10;
        }
        return num;
    }
}
