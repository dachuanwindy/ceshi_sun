package SuanFa_study.LRU_study;

import java.util.LinkedHashMap;
import java.util.Map;

public class TestCache {
    public static void testLinkedHashMap() {
        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>(5, 0.75F, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
                //当LinkHashMap的容量大于等于5的时候,再插入就移除旧的元素
                return this.size() >= 5;
            }
        };
        map.put("aa", "bb");
        map.put("cc", "dd");
        map.put("ee", "ff");
        map.put("gg", "hh");
        print(map);
        map.get("cc");
        System.out.println("===================================");
        print(map);

        map.get("ee");
        map.get("aa");
        System.out.println("====================================");
        map.put("ss", "oo");
        print(map);


    }

    static void print(LinkedHashMap<String, String> source) {
        source.keySet().iterator().forEachRemaining(System.out::println);
    }


    public static void main(String[] args) {

        testLinkedHashMap();
    }
}