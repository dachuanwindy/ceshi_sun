package inspur.Redis;

import redis.clients.jedis.Jedis;

import javax.xml.bind.SchemaOutputResolver;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class Redis {

    private static Jedis jedis;

    public static void main(String[] args) {
        // 连接本地的 Redis 服务
        // 查看服务是否运行
        connction();
        //  Jedis jedis =new Jedis();
        //     jedis = new Jedis("127.0.0.1");
        System.out.println("Server is running: " + jedis.ping());
        String keys = "name";
        jedis.expire("ceshi", 10);
        jedis.del(keys);


        String vaule = jedis.set(keys, "sunfengchuanhao");

        jedis.set("ceshi", "sunfengchian");
        jedis.get("ceshi");
        System.out.println(jedis.get("ceshi"));

        System.out.println(jedis.get("slowlog-max-len"));
        //  jedis.expire("ceshi" ,10);

        List<String> ceshi2 = jedis.configGet("slowlog-max-len");

        System.out.println("配置文件为" + ceshi2.toString());
        jedis.get("erer");
        System.out.println(jedis.get("erer"));

        RedisMap(); // redisMap 存储
        ceshi3_hashmap(); //

        setNx();  // setNx 方法测试


    }

    private static void connction() {
        jedis = new Jedis("39.96.176.6");
        System.out.println("Redis连接成功");
    }

    // 实现hashmap 的存储
    public static void RedisMap() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("sun", "12");
        map.put("sun1", "121");
        map.put("sun2", "122");
        map.put("sun3", "123");
        jedis.hmset("ceshi11", map);

        String ddf = jedis.hmset("key", map);

        jedis.hget("key", "sun1");

        List rsmap = jedis.hmget("ceshi11", "sun", "sun2");
        System.out.println(rsmap.toString());
    }

    public static void ceshi3_hashmap() {

        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "xinxin");
        map.put("age", "22");
        map.put("qq", "123456");
        jedis.hmset("user", map);
        //取出user中的name，执行结果:[minxr]-->注意结果是一个泛型的List
        //第一个参数是存入redis中map对象的key，后面跟的是放入map中的对象的key，后面的key可以跟多个，是可变参数
        List<String> rsmap = jedis.hmget("user", "name", "qq");
        System.out.println(rsmap);
    }

    public static void setNx() {

        long result = jedis.setnx("Key_setnx", "123456");

        if (result == 1) {

            ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(20);
            arrayBlockingQueue.add("11");
            arrayBlockingQueue.peek();

        }

        System.out.println("=====>" + result);
    }

}

class ttt {
    public static void main(String[] args) throws InterruptedException {


        SynchronousQueue  s = new SynchronousQueue();
        s.put("a");
        s.put("b");
        s.put("c");
        s.put("s");
        s.put("f");
        s.put("e");

        System.out.println(s.take());
        System.out.println(s.take());

        System.out.println(s);


    }
}