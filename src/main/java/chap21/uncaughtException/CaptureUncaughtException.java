package chap21.uncaughtException;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

class ExceptionThread2 implements Runnable {

    @Override
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println("run by " + t);
        System.out.println(
                "eh = " + t.getUncaughtExceptionHandler()
        );
        throw new RuntimeException();
    }
}

/**
 * 会在线程因未能捕获的异常而临近死亡时被调用 uncaughtException()方法
 */
class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("caught " + e);
    }
}

/**
 * 通过实现一个新类型的ThreadFactory
 * 在每一个新创建的对象上附着一个Thread.UncaughtExceptionHandle
 *
 * @author crystal303
 */
class HandlerThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        System.out.println(this + " creating new Thread");
        Thread t = new Thread(r);
        System.out.println("Created " + t);
        // 设置Handler
        t.setUncaughtExceptionHandler(
                new MyUncaughtExceptionHandler()
        );
        System.out.println(
                "eh = " + t.getUncaughtExceptionHandler()
        );
        return t;
    }
}


public class CaptureUncaughtException {
    public static void main(String[] args) {
        // 将ThreadFactory对象传入 生成新的ExecutorService对象
        ExecutorService exec = Executors.newCachedThreadPool(new HandlerThreadFactory());
        exec.execute(new ExceptionThread2());
        exec.shutdown();

    }
}
