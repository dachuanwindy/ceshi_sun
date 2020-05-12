package temp.PX_bubble_temp;

/**
 * @author sunfch
 * @create 2018-11-21 9:53
 * @desc 冒泡排序
 **/
public class Bubble_temp {

    public static void Bubble_temp(int[] arry) {

        for (int i = 0; i < arry.length; i++)
            for (int j = i+1; j < arry.length; j++) {
                if (arry[i] > arry[j]) {
                    int temp = arry[i];
                    arry[i] = arry[j];
                    arry[j] = temp;
                }
            }
    }

    public static void main(String[] args) {
        int[] arry= {1,2,3,5,9,8};

        Bubble_temp(arry);
        for (int i = 0; i <arry.length; i++) {

            System.out.println(arry[i]);
            
        }
    }
}
