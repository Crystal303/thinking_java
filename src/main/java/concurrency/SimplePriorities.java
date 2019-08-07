package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 优先级较低的线程仅仅是执行频率较低
 * 在绝大多数时间里 所有线程都应该以默认的优先级运行
 * 试图操作线程优先级通常是一种错误 数学计算够被打断 控制台输出不能
 *
 * @author crystal303
 */
public class SimplePriorities implements Runnable {
    private int countDown = 5;
    private volatile double d;
    private int priority;

    public SimplePriorities(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return Thread.currentThread() + ": " + countDown;
    }

    @Override
    public void run() {
        Thread.currentThread().setPriority(priority);
        while (true) {
            for (int i = 0; i < 10000; i++) {
                d += (Math.PI + Math.E) / (double)i;
                if (i % 1000 == 0) {
                    Thread.yield();
                }
            }
            System.out.println(this);
            if (--countDown == 0) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(
                    new SimplePriorities(Thread.MIN_PRIORITY)
            );
        }
        exec.execute(
                new SimplePriorities(Thread.MAX_PRIORITY)
        );
        exec.shutdown();

    }
}
