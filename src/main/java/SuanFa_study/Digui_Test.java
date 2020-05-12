package SuanFa_study;

/**
 * @author sunfch
 * @create 2018-10-14 16:57
 * @desc 递归展示
 **/
public class Digui_Test {
    public static void main(String[] args) {
          Digui(10);
    }

    public static void Digui(int a) {
        if (a == 0) {
            return;
        }
        System.out.println("=====>"+ a);
        Digui(a - 1);

    }
}
