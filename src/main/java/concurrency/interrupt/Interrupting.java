package concurrency.interrupt;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 线程中断 调用interrupt() 必须持有Thread对象 避免对Thread对象的直接操作
 * shutdownNow()向Executor持有的线程全部发送interrupt()
 *
 * 中断某一任务 submit()提交 持有上下文Future<?> 调用cancel()中断任务
 *
 * @author crystal303
 */
public class Interrupting {
    private static ExecutorService exec = Executors.newCachedThreadPool();

    static void test(Runnable r) throws InterruptedException {
        // 不会调用f.get()
        Future<?> f = exec.submit(r);
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("Interrupting " + r.getClass().getName());
        // 使其拥有在线程上调用interrupt()以停止该任务的权限 Interrupts if running
        f.cancel(true);
        System.out.println("Interrupt sent to " + r.getClass().getName());
    }
    public static void main(String[] args) throws InterruptedException {
        test(new SleepBlocked());
        test(new IOBlocked(System.in));
        test(new SynchronizedBlocked());
        TimeUnit.SECONDS.sleep(3);
        System.out.println("Aborting with System exit(0)");
        // ... since last 2 interrupts failed
        System.exit(0);
    }
}

/**
 * 可中断的阻塞示例
 */
class SleepBlocked implements Runnable {
    /**
     * 异常从来不能异步的传递 抛出异常 互斥释放
     */

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        }
        System.out.println("Exiting SleepBlocked.run()");
    }

}

/**
 * 不可中断的阻塞示例 BIO
 * 不需要InterruptedException处理器
 */
class IOBlocked implements Runnable {
    private InputStream in;

    public IOBlocked(InputStream is) {
        in = is;
    }

    @Override
    public void run() {
        System.out.println("Waiting for read(): ");
        try {
            in.read();
        } catch (IOException e) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Interrupted from blocked I/O");
            } else  {
                // 抛出异常 互斥自动释放
                throw new RuntimeException(e);
            }
        }
        System.out.println("Exiting IOBlocked.run()");
    }
}

/**
 * 不可中断的阻塞示例
 * 锁住多线程程序潜在的可能
 */
class SynchronizedBlocked implements Runnable {
    public synchronized void f() {
        while (true) {
            Thread.yield();
        }
    }

    public SynchronizedBlocked() {
        // 让不同对象获得锁
        new Thread() {
            @Override
            public void run() {
                // Lock acquired by this thread
                f();
            }
        }.start();
    }

    @Override
    public void run() {
        System.out.println("Trying to call f()");
        f();
        System.out.println("Exiting SynchronizedBlocked.run()");
    }
}
