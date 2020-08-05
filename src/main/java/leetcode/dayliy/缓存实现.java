package leetcode.dayliy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sunfch
 * @version V1.0
 * @Description: TODO
 * @date 2020/8/2 16:05
 */
public class 缓存实现 {

    private int capacity;
    private Map<Integer, Node> map = new HashMap<>(capacity);
    private Node head = null, tail = null;

    缓存实现(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {

        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            setHead(node);
            return node.value;
        }
        return -1;
    }

    /**
     * @description: 添加值
     * @author sunfch
     * @date 2020/8/2 16:19
     */
    public void set(int key, int value) {
        if (map.containsKey(key)) {
            Node old = map.get(key);
            old.value = value;
            remove(old);
            setHead(old);
        } else {
            Node createNode = new Node(key, value);
            if (map.size() >= capacity) {
                map.remove(tail.key);
                remove(tail);
                setHead(createNode);
            } else {
                setHead(createNode);
            }
            map.put(key, createNode);
        }
    }

    /**
     * @description: 将节点放到头部
     * @author sunfch
     * @date 2020/8/2 16:09
     */
    private void setHead(Node node) {
        node.next = head;
        node.pre = null;
        if (head != null) {
            head.pre = node;
        }
        head = node;
        if (tail == null) {
            tail = head;
        }
    }

    /**
     * @description: 删除节点
     * @author sunfch
     * @date 2020/8/2 16:09
     */
    private void remove(Node node) {

        if (node.pre != null) {
            node.pre.next = node.next;
        } else {
            head = node.next;
        }
        if (node.next != null) {
            node.next.pre = node.pre;
        } else {
            tail = node.pre;
        }
    }


    class Node {
        int key;
        int value;
        Node next;
        Node pre;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }


}

