package ZK.distributezookeeperlock;

import java.util.concurrent.TimeUnit;

/**
 * @author sunfch
 * @create 2018-10-24 9:41
 * @desc 简单分布式锁实现
 **/
public class SimpleDistributeLock     implements  DistributedLock   {
    @Override
    public void acquire() throws Exception {

    }

    @Override
    public boolean aquire(long time, TimeUnit unit) throws Exception {
        return false;
    }

    @Override
    public void release() {

    }
}
