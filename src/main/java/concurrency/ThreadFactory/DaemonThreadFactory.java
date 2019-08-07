package concurrency.ThreadFactory;

import java.util.concurrent.ThreadFactory;

/**
 * 编写定制的ThreadFactory 定制由Executor创建的线程的属性（后台、优先级、名称）
 *
 * @author crystal303
 */
public class DaemonThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    }
}
