package com.Redis.Redis_study;


import redis.clients.jedis.Jedis;

/**
 * @author sunfch
 * @create 2018-03-16 21:12
 * @desc 面试学习Redis
 **/


public class Redis_study {


    public static void main(String[] args) {
        System.out.println("Redis 学习----");
        Jedis jedis = new Jedis("39.96.176.6", 6379);
//        jedis.auth("inspur");
        jedis.set("111", "2222");


        jedis.get("111");

        System.out.println(jedis.get("111"));

        jedis.get("");

        System.out.println(jedis.get("KEY_REDIS_PRE:DM_GY_SWJG_1"));

        System.out.println(jedis.get("111").length());

       /* jedis.set("sunfengchuan", "sunfengchuaneeeee");
        String dd = jedis.get("sunfengchuan");

        System.out.println("" + dd);

        Map<String, String> map = new HashMap<String, String>();

        map.put("sunf", "sunfenghcuan");
        map.put("sunf1", "sunfenghcuan1");
        map.put("sunf2", "sunfenghcuan2");
        map.put("sunf3", "sunfenghcuan3");


        jedis.set("map", String.valueOf(map));

        String o = jedis.get("map");
        jedis.set("sunf".getBytes(), "111111".getBytes());
        byte[] sss = jedis.get("sunf".getBytes());

        jedis.sort("12");
        jedis.sort("12");
        jedis.sort("12");
        jedis.sort("12");

        String ceshi = jedis.get("string_sun");

        String a = jedis.lpop("list_ceshi");
*/
    }


}

class arrylist {
    public static void main(String[] args) {
        System.out.println("数组学习------");

        myArryl myArryl = new myArryl();
        myArryl.add_date(1);

        myArryl.delet_date(1);

        myArryl.display();

    }


}


class myArryl {

    private int elements = 0; //数组长度

    private long[] arr;

    public myArryl() {

        arr = new long[50];
    }

    public myArryl(int maxsize) {

        arr = new long[maxsize];
    }

    // 增数据
    public void add_date(long value) {
        arr[elements] = value;
        elements++;
    }

    //删除数据
    public void delet_date(long value) {
        int i;
        for (i = 0; i < elements; i++) {
            if (value == arr[i])
                break;
            arr[i] = arr[i++];
        }


    }

    //查询数据
    public long find_data(long value) {

        int i = 0;
        for (; i < elements; i++) {
            if (value == arr[i])
                return value;
        }
        return -1;
    }

    public void display() {
        System.out.println("[");

        for (int i = 0; i < elements; i++) {

            System.out.println(arr[i] + ",");
        }
        System.out.println("]");
    }
}
