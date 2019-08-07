package concurrency;

/**
 * 在其他对象同步 确保所有相关的任务都是在同一个对象上同步的
 * 示例
 * 两个任务可以同时进入同一个对象 只要这个对象上的方法是在不同的锁上同步的
 *
 * @author crystal303
 */
public class SyncObject {
    public static void main(String[] args) {
        final DualSynch ds = new DualSynch();
        new Thread() {
            @Override
            public void run() {
                ds.f();
            }
        }.start();
        ds.g();
    }
}

class DualSynch {
    private Object syncObject = new Object();
    public synchronized void f() {
        for (int i = 0; i < 5; i++) {
            System.out.println("f()");
            Thread.yield();
        }
    }

    public void g() {
        synchronized (syncObject) {
            for (int i = 0; i < 5; i++) {
                System.out.println("g()");
                Thread.yield();
            }
        }
    }
}
