package others.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 实现非阻塞同步
 * AtomicInteger
 * @author crystal303
 */
public class Counter {
    private AtomicInteger count = new AtomicInteger();
    public void increment() {
        count.incrementAndGet();
    }

    /**
     *
     * 使用AtomicInteger之后，不需要加锁也能实现线程安全
     */
    public int getCount() {
        return count.get();
    }
}
