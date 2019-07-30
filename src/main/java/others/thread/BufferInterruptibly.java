package others.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 互斥同步 信号量 互斥量 临界区
 * synchronized 语法级的同步锁 字节码会生成两个关键字 monitorEnter monitorExit
 * ReentrantLock 多个条件 等待中断
 * 吞吐量后者更高且稳定 ReentrantLock 单核和多核都较好
 */
public class BufferInterruptibly {
    private ReentrantLock lock = new ReentrantLock();

    public void write() {
        lock.lock();
        try {
            long start = System.currentTimeMillis();
            System.out.println("开始往这个buff写入数据");
            for(;;) {
                if(System.currentTimeMillis() - start > 10000) {
                    break;
                }
            }
            System.out.println("终于写完了");
        } finally {
            lock.unlock();
        }
    }

    public void read() {
        // 可以响应中断
        try {
            lock.lockInterruptibly();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("从这个buff读数据");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        BufferInterruptibly bi = new BufferInterruptibly();
        ExecutorService exec = Executors.newCachedThreadPool();
        try {
            exec.execute(()->bi.read());
            exec.execute(()->bi.read());
            exec.execute(()->bi.read());
            exec.execute(()->bi.read());
            exec.execute(()->bi.read());
            exec.execute(()->bi.write());
            exec.execute(()->bi.write());
            exec.execute(()->bi.write());
            exec.execute(()->bi.write());
            exec.execute(()->bi.write());
        } finally {
            exec.shutdown();
        }

    }
}
