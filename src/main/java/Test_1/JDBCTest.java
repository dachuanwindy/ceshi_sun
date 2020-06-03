package Test_1;


import java.sql.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

/**
 * JDBC 连接过程，
 *
 * @author sunfch
 */

public class JDBCTest {
    public static void main(String[] args) throws ClassNotFoundException {

        Class.forName("com.mysql.jdbc.Driver");

        String url = "";
        String password = "";
        String username = "";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("");

            while (resultSet.next()) {

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put("", "");

        concurrentHashMap.putIfAbsent("", "");

        ReentrantLock lock = new ReentrantLock();
        try {
            lock.tryLock();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();

        }

    }
}

class MyLock extends AbstractQueuedSynchronizer {

//    static class syncLock extends AbstractQueuedSynchronizer {
//        void  lock(){
//            if (compareAndSetState(0, 1)) {
//                setExclusiveOwnerThread(Thread.currentThread());
//            } else {
//                acquire(1);
//            }
//        }
//    }

    public void lock() {
        if (compareAndSetState(0, 1)) {
            setExclusiveOwnerThread(Thread.currentThread());
        }
    }

    public boolean unlock(int releases) {
        int c = getState() - releases;
        if (Thread.currentThread() != getExclusiveOwnerThread()) {
            throw new IllegalMonitorStateException();
        }
        boolean free = false;
        if (c == 0) {
            free = true;
            setExclusiveOwnerThread(null);
        }
        setState(c);
        return free;
    }


}


