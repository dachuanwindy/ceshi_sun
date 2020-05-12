package ZK.distributezookeeperlock;

import java.util.concurrent.TimeUnit;

public interface DistributedLock {

    public void acquire() throws Exception;

    public boolean aquire(long time, TimeUnit unit) throws Exception;

    //释放锁
    public void release();
}
