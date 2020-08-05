package inspur.Thread_study.Threadpool_2;

/**
 * @author sunfch
 * @version V1.0
 * @Description: TODO
 * @date 2020/7/30 16:11
 */
public class 线程异常捕获学些 {


    public static class TestRuntimeExceptionThread extends Thread {
        public TestRuntimeExceptionThread() {
            super.setName("thread-TestRuntimeExceptionThread");
        }

        @Override
        public void run() {
            throw new RuntimeException("run time exception");
        }
    }

    public static void main(String[] args) {
        try {
            Thread test = new TestRuntimeExceptionThread();
            // 设置线程默认的异常捕获方法
            test.setUncaughtExceptionHandler((Thread t, Throwable e) -> {
                System.out.println(t.getName() + ": " + e.getMessage());
            });
            test.start();
        } catch (Exception e) {
            System.out.println("catch thread exception");
        }
    }


}
