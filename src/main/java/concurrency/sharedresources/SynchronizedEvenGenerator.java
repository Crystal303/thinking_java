package concurrency.sharedresources;

/**
 * 一个任务可以多次获得对象的锁 进行计数
 * 同步控制EventGenerator
 *
 * 针对每一个类 也有一个锁（作为类的Class对象的一部分） synchronized static方法可以在类的范围内防止对static数据的并发访问
 * Brain的同步规则 每个访问临界资源的方法都必须被同步 否则他们就不会正常的工作
 *
 * @author crystal303
 */
public class SynchronizedEvenGenerator  extends IntGenerator{
    /**
     * 私有化 否则synchronized不能防止其他任务直接访问域
     */
    private int currentEvenValue = 0;

    @Override
    public synchronized int next() {
        ++currentEvenValue;
        // cause failure faster
        Thread.yield();
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new SynchronizedEvenGenerator());
    }
}
