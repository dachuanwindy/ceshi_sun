package SuanFa_study.LRU_study;

import java.util.HashMap;

public class LRU_study {
}

class Node {
    int key;
    int value;
    Node pre;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return this.key + "=====" + this.value;
    }
}

class LRUCacheTest {
    int capacity;
    HashMap<Integer, Node> map = new HashMap<>();
    Node head = null;
    Node end = null;

    public LRUCacheTest(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            remove(n);
            setHead(n);
            return n.value;

        }
        return -1;
    }

    /**
     * @Description: 将 查询的值放在最前面
     * @Author: sunfch
     * @Date: 2019/2/20-18:57
     * @Param:
     * @Return:
     */
    private void setHead(Node n) {
        n.next = head;
        n.pre = null;

        if (head != null) {
            head.pre = n;
        }
        head = n;
        if (end == null) {
            end = head;
        }
    }

    /**
     * @Description: 移除
     * @Author: sunfch
     * @Date: 2019/2/20-19:01
     * @Param:
     * @Return:
     */
    private void remove(Node n) {
        if (n.pre != null) {
            n.pre.next = n.next;
        } else {
            head = n.next;
        }

        if (n.next != null) {
            n.next.pre = n.pre;
        } else {
            end = n.pre;
        }
    }

    /**
     * @Description: 存放值
     * @Author: sunfch
     * @Date: 2019/2/20-19:18
     * @Param:
     * @Return:
     */
    public void set(int key, int value) {
        if (map.containsKey(key)) {
            Node old = map.get(key);
            old.value = value;
            remove(old);
            setHead(old);
        } else {
            Node createnode = new Node(key, value);
            if (map.size() >= capacity) {
                map.remove(end.key);
                remove(end);
                setHead(createnode);
            } else {
                setHead(createnode);
            }
            map.put(key, createnode);

        }
        printNodes("set");
    }

    public void printNodes(String explain) {
        System.out.println(explain + ":" + head.toString());
        Node node = head.next;
        while (node != null) {
            System.out.println(node.toString());
            node = node.next;
        }
        System.out.println();
    }

    /**
     * @Description: 主函数，实现
     * @Author: sunfch
     * @Date: 2019/2/20-19:21
     * @Param:
     * @Return:
     */
    public static void main(String[] args) {

        LRUCacheTest lruCacheTest = new LRUCacheTest(10);

        lruCacheTest.set(1, 1);
        lruCacheTest.set(2, 2);
        lruCacheTest.set(3, 3);
        lruCacheTest.set(4, 4);
        System.out.println(lruCacheTest.get(1));
        lruCacheTest.set(5, 5);

    }

}



