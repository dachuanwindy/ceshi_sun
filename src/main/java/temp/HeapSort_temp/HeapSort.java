package temp.HeapSort_temp;

/**
 * @author sunfc
 * @create 2018-11-20 22:06
 * @desc 堆排序  从小到大的顺序排序
 **/
public class HeapSort {

    public static void NodeAjust(int[] arry, int s, int length) {

        int temp = arry[s];
        int child = 2 * s + 1;
        while (child < length) {

            if (child + 1 < length && arry[child] < arry[child + 1]) {
                child++;
            }
            if (arry[s] < arry[child]) {
                arry[s] = arry[child];
                s = child;
                arry[child] = temp;
                child = 2 * s + 1;
            } else {
                break;
            }
        }
    }

    public static void heapsort(int[] arry) {

        System.out.println("开始排序 从小到大的顺序");

        for (int i = (arry.length - 1) / 2; i >= 0; i--) {
            NodeAjust(arry, i, arry.length);
        }
        for (int i = arry.length - 1; i > 0; i--) {

            int temp = arry[i];
            arry[i] = arry[0];
            arry[0] = temp;
            NodeAjust(arry, 0, i);
        }
    }

    public static void main(String[] args) {
        int[] ar = {10, 3, 5, 6, 7, 9,2 ,30,50};
        heapsort(ar);
        for (int i : ar) {
            System.out.print(i + " ");
        }
    }
}
