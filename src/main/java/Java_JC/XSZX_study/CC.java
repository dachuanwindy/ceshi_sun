package Java_JC.XSZX_study;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * @Description: 向上转型，向下转型
 * @Author: sunfch
 * @Date: 2019/2/20-18:35
 * @Param:
 * @Return:
 */
class AA {

    public void a1() {
        System.out.println("方法1");
    }

}

class BB extends AA {

    public void a1() {
        System.out.println("重写了父类方法");
    }

    public void b1() {
        System.out.println("fang fa b1");
    }

    public void b2() {

        System.out.println(" 方法  b2");
    }

}

public class CC {

    public static void main(String[] args) {

        System.out.println("乡下转型");
        AA aa = new BB();
        // 向上转型；；
        aa.a1();
        // BB  bb = (BB) new AA();  // 向下转型，是强制转型，
        //bb.b2();//此时编译并不会出错，但是 运行就会报错，
        //   bb.a1();


        Collection<Integer> c = new ArrayList<Integer>();
        for (int i = 2; i < 10; i++) {
            c.add(i);
        }
        for (int i : c) {
            System.out.println(i);
        }

        c.remove(2);
        LinkedList linkedList = new LinkedList();


    }


}