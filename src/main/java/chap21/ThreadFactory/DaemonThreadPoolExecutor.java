package chap21.ThreadFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 通过两个类分别实现ThreadFactory、ThreadPoolExecutor接口
 * 后者传入传入ThreadFactory对象实现创建Executor(执行器)
 * ExecutorService--具有服务生命周期的Executor,例如关闭
 *
 * @author crystal303
 */
public class DaemonThreadPoolExecutor extends ThreadPoolExecutor {
    public DaemonThreadPoolExecutor() {
        super(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>(),
                new DaemonThreadFactory());
    }

    public static void main(String[] args) {
        ExecutorService exec = new DaemonThreadPoolExecutor();
        // 经过测试 最多开启五个线程
        for (int i = 0; i < 5; i++) {
            exec.execute(new A());
        }
        System.out.println("all daemons started");
        exec.shutdown();
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class A implements Runnable {
    private static int count = 0;

    @Override
    public void run() {
        while (true) {
            try {
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ++count;
            if (count >> 2 == 100) {
                System.out.println(Thread.currentThread() + " is down! " + "isDaemon() " + Thread.currentThread().isDaemon());
                Thread.yield();
            }
        }
    }
}
