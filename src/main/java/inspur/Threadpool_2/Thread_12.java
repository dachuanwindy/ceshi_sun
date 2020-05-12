package inspur.Threadpool_2;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

public class Thread_12 {


    public static void main(String[] args) {
        System.out.println("多线程任务学些");

        ArrayList ceshi = new ArrayList();
        for (int i = 0; i < 5; i++) {
            ceshi.add(i, "dfdfd" + i);
        }

        for (int j = 0; j < ceshi.size(); j++) {
            System.out.println("arrylist的输出为" + ceshi.get(j));
        }


        Hashtable hashtable = new Hashtable();
        hashtable.put("sunfengch", "sseeer基础了");
        System.out.println(hashtable.get("sunfengch"));

        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put("sun", "jiangshan");
        Object ceer = concurrentHashMap.get("sun");
        System.out.println("shuch++++++=====" + ceer.toString());
    }


}
