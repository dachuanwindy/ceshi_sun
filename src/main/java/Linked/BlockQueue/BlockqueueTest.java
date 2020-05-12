package Linked.BlockQueue;


import java.util.LinkedList;

/**
 * @Description: 手写阻塞队列
 * @Author: sunfch
 * @Date: 2019/2/28-14:17
 * @Param:
 * @Return:
 */
public class BlockqueueTest {
    private LinkedList<String> container = new LinkedList<>();

    private int count;

    /**
     * @Description: 添加数据
     * @Author: sunfch
     * @Date: 2019/2/28-14:27
     * @Param:
     * @Return:
     */
    public void put(String str) {
        synchronized (this) {
            container.add(str);
            this.notify();
        }
    }

    /**
     * @Description: 取数据，这个时候是通过
     * @Author: sunfch
     * @Date: 2019/2/28-14:27
     * @Param:
     * @Return:
     */
    public String take() throws InterruptedException {
        synchronized (this) {
            while (container.size() == 0) {
                this.wait();
            }
            return container.removeFirst();
        }
    }
}
