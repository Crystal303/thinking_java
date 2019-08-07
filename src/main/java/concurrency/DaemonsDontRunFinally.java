package concurrency;

import java.util.concurrent.TimeUnit;

/**
 * 测试Daemon线程可能不执行finally字句就会终止run()方法
 *
 * @author crystal303
 */
public class DaemonsDontRunFinally {
    public static void main(String[] args) {
        Thread t = new Thread(new ADaemon());
        t.setDaemon(true);
        t.start();
    }
}

/**
 * 辅助类
 *
 * @author crystal303
 */
class ADaemon implements Runnable {

    @Override
    public void run() {
        System.out.println("Starting ADaemon");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("This should always run?");
        }
    }
}
