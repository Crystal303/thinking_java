package chap21.ThreadFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 后台线程工厂类测试
 *
 * @author crystal303
 */
public class DaemonFromFactory implements Runnable {
    @Override
    public void run() {
        while (true) {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + "" + this);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // 每个静态的ExecutorService创建方法都被重载为接受一个ThreadFactory对象 该对象用来创建新线程
        ExecutorService exec = Executors.newCachedThreadPool(
                new DaemonThreadFactory()
        );
        for (int i = 0; i < 10; i++) {
            exec.execute(new DaemonFromFactory());
        }
        System.out.println("All daemons started");
        TimeUnit.MILLISECONDS.sleep(500);
    }
}
