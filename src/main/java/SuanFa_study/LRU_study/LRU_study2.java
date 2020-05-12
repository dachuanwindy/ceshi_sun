package SuanFa_study.LRU_study;

import java.util.HashMap;

public class LRU_study2 {
}

class Nodes {
    int key;
    int value;
    Nodes pre;
    Nodes next;

    public Nodes(int key, int value) {
        this.value = value;
        this.key = key;
    }
}

class LRUStudy {

    private HashMap<Integer, Nodes> map = new HashMap();
    Nodes head;
    Nodes end;

    public void setNodes(int key, int value) {
        if (map.containsKey(key)) {
            Nodes old = map.get(key);
            old.value = value;
            removeOld(old);

        }
    }

    /**
     * @Description: 删除 老的节点
     * @Author: sunfch
     * @Date: 2019/3/3-19:55
     * @Param:
     * @Return:
     */
    private void removeOld(Nodes old) {
        //若老节点的的头结点为空，证明是头结点，若不为空，将头结点的下一个节点，指向old 的下一个节点
        if (old.pre != null) {
            old.pre.next = old.next;
        } else {
            head = old.next;
        }
    }


}

