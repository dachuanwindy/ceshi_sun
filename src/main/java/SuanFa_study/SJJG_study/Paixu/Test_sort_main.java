package SuanFa_study.SJJG_study.Paixu;

public class Test_sort_main {
    public static void main(String[] args) {
        System.out.println("排序汇总");
        int[] shuzu = {1, 3, 7, 2, 8, 5, 10};
        System.out.println("插入排序");

        InsertSort insertSort = new InsertSort();
        insertSort.Insert_sort(shuzu);

    }
}

class InsertSort {
    public void Insert_sort(int[] arr) {
        int temp=0;
        for (int i = 1; i < arr.length; i++) {
            temp = arr[i];
            int j = i;
            while (j > 0 && arr[j] >= temp) {
                arr[j-1] = arr[j];
                j--;
            }
            arr[j] = temp;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
    }
}