package SuanFa_study.paixu_heap;

/**
 * @author sunfch
 * @create 2018-11-13 21:59
 * @desc
 **/


public class HeapSort {

    public int[] heapSort(int[] A, int n) {

        int lastIndex = n - 1;

        buildMaxHeap(A, lastIndex);//建立最大堆

        while (lastIndex > 0) {

            swap(A, 0, lastIndex);

            if (--lastIndex == 0)//只剩一个元素，就不用调整堆了，排序结束

                break;

            adjustHeap(A, 0, lastIndex);

        }

        return A;

    }


    public void buildMaxHeap(int[] arr, int lastIndex) {
        // 从最后一个元素的父节点开始进行调整，一直调整到根节点结束
        int j = (lastIndex - 1) / 2;
        while (j >= 0) {
            int rootIndex = j;
            adjustHeap(arr, rootIndex, lastIndex);
            j--;
        }

    }

    public void adjustHeap(int[] arr, int rootIndex, int lastIndex) {//从根节点开始往下调整

        int biggerIndex = rootIndex;
        int leftChildIndex = rootIndex * 2 + 1;
        int rightChildIndex = rootIndex * 2 + 2;
        if (rightChildIndex <= lastIndex) {//如果右孩子存在，则左孩子一定存在
            if (arr[rightChildIndex] > arr[rootIndex] || arr[leftChildIndex] > arr[rootIndex]) {
                //将子节点更大的元素下标赋值给biggerIndex
                biggerIndex = arr[rightChildIndex] > arr[leftChildIndex] ? rightChildIndex : leftChildIndex;
            }
        } else if (leftChildIndex <= lastIndex) {//保证左孩子存在，且不能越界
            if (arr[leftChildIndex] > arr[rootIndex]) {
                biggerIndex = leftChildIndex;
            }
        }

        if (biggerIndex != rootIndex) {
            swap(arr, biggerIndex, rootIndex);
            adjustHeap(arr, biggerIndex, lastIndex);
        }

    }


    public void swap(int[] arr, int biggerIndex, int rootIndex) {

        int temp = arr[rootIndex];

        arr[rootIndex] = arr[biggerIndex];

        arr[biggerIndex] = temp;

    }

}

