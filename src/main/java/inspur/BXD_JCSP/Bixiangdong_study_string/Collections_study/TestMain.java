package inspur.BXD_JCSP.Bixiangdong_study_string.Collections_study;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * linkedList  可以完成先进先出，先进后出的功能
 */
public class TestMain {

    public static void main(String[] args) {
        System.out.println("常规知识点要掌握===");


      /*  Duilie dl = new Duilie();
        dl.myadd("java-1");
        dl.myadd("java-2");
        dl.myadd("java-3");
        dl.myadd("java-4");
        while (!dl.isNull()) {
            System.out.println(dl.myGet());
        }*/


        ArrayList d1 = new ArrayList();
        d1.add("A1");
        d1.add("A2");


        ArrylistTest al1 = new ArrylistTest();
        ArrayList l2 = al1.SingleElement(d1);
        Iterator it2 = l2.iterator();
        while (it2.hasNext()) {
            System.out.println(it2.next());
        }

    }
}

class Duilie {

    private LinkedList link;

    Duilie() {
        this.link = new LinkedList();
    }

    public void myadd(Object object) {

        link.addFirst(object);
    }

    // 获取当前值
    public Object myGet() {
        return link.removeLast();
    }

    public boolean isNull() {
        return link.isEmpty();
    }
}
class ArrylistTest {
    static ArrayList arrayList = new ArrayList();
    public ArrayList SingleElement(ArrayList list) {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            if (!arrayList.contains(iterator.next())) {
                arrayList.add(iterator.next());
            }
        }
        return arrayList;
    }
}