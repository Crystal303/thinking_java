package concurrency.exercise;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * 定制的ThreadFactory能够设置优先级
 * 测试
 *
 * @author crystal303
 */
public class Ex9 implements Runnable {
    private int countDown = 5;
    private volatile double d;

    @Override
    public String toString() {
        return Thread.currentThread() + ": " + countDown;
    }

    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < 100000; i++) {
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
        // TODO: 19-8-1 fail
        ExecutorService exec = Executors.newCachedThreadPool(
                // new SetPrioritiesThreadFactory()
        );
        for (int i = 0; i < 5; i++) {
            exec.execute(new Ex9());
        }
        exec.execute(new Ex9());
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        exec.shutdown();
    }
}

class SetPrioritiesThreadFactory implements ThreadFactory {
    Random rand = new Random();
    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread();
        int i = rand.nextInt(3);
        switch (i) {
            case 0 : t.setPriority(Thread.MIN_PRIORITY); break;
            case 1 : t.setPriority(Thread.NORM_PRIORITY); break;
            case 2 : t.setPriority(Thread.MAX_PRIORITY); break;
        }
        return t;
    }
}
