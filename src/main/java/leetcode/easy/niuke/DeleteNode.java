package leetcode.easy.niuke;

import lombok.Data;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 删除链表中倒数第K个节：
 * @date 2020/3/24 12:01
 */
public class DeleteNode {

    public static void main(String[] args) throws InterruptedException {

    }

    @Data
    class Node {
        int data;
        Node next;
    }

    static class Link {

        static int findKey(Node firstNode, int k) {

            Node firstLink = firstNode;
            Node backFlower = firstNode;

            while (k-- != 0) {
                firstLink = firstLink.next;
            }
            while (firstLink != null) {
                firstLink = firstNode.next;
                backFlower = backFlower.next;
            }
            return backFlower.data;
        }

        static void deleteNode(Node firstNode, int k) {
            Node firstLink = firstNode;
            Node backFlower = firstNode;

            while (k-- != 0) {
                firstLink = firstLink.next;
            }
            while (firstLink.next != null) {
                firstLink = firstNode.next;
                backFlower = backFlower.next;
            }
            backFlower.next = backFlower.next.next;
        }

    }
}