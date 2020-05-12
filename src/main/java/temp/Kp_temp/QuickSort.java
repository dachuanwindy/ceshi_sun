package temp.Kp_temp;

/**
 * @author sunfch
 * @create 2018-11-21 9:35
 * @desc 快速排序
 **/
public class QuickSort {
    public static void QuickSort(int[] a, int left, int right) {
        if (left > right) {
            return;
        }

        int i = left;
        int j = right;
        int temp;
        int base = a[left];
        while (i <= j) {
            while (a[i] < base && i < right) i++;
            while (base < a[j] && left < j) j--;
            if (i <= j) {
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j--;
            }
        }
        if (left < j) {
            QuickSort(a, left, j);
        }
        if (right > i) {
            QuickSort(a, i, right);
        }
    }

    public static void main(String[] args) {

        int[] arry = {1, 2, 3, 4, 7, 8, 5,6};
//        QuickSort(arry, 0, arry.length - 1);

        Sort sort = new Sort();
        sort.Kp(arry, 0, arry.length - 1);

        for (int a : arry) {
            System.out.println(a);
        }


    }
}


class Sort {

    public void Kp(int[] arry, int begin, int end) {
        int i = begin;
        int j = end;
        if (i > j) {
            return;
        }
        int temp;

        int base = arry[i];

        while (i <= j) {
            while (i < j && arry[i] < base) {
                i++;
            }
            while (i < j && arry[j] > base) {
                j--;
            }
            if (i <= j) {
                temp = arry[i];
                arry[i] = arry[j];
                arry[j] = temp;
                i++;
                j--;
            }

        }
        if (begin < j) {

            Kp(arry, begin, j);
        }
        if (end > i) {

            Kp(arry, i, end);
        }

    }


}