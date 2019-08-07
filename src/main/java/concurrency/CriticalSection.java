package concurrency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 如何把一个非保护类型的类 在其他类的保护和控制之下 应用于多线程的环境
 * （临界区)
 * 
 * @author crystal303 
 */
public class CriticalSection {
    /**
     * Test the two different approaches
     */
    static void testApproaches(PairManager pman1, PairManager pman2) {
        ExecutorService exec = Executors.newCachedThreadPool();
        PairManipulator
                pm1 = new PairManipulator(pman1),
                pm2 = new PairManipulator(pman2);
        PairChecker
                pCheck1 = new PairChecker(pman1),
                pCheck2 = new PairChecker(pman2);
        exec.execute(pm1);
        exec.execute(pm2);
        exec.execute(pCheck1);
        exec.execute(pCheck2);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch(InterruptedException e) {
            System.out.println("sleep interrupted");
        }
        System.out.println("pm1: " + pm1 + "\npm2: " + pm2);
        System.exit(0);
    }

    public static void main(String[] args) {
        PairManager
                pman1 =  new PairManager1(),
                        // new ExplicitPairManager1(),
                pman2 =  new PairManager2();
                        // new ExplicitPairManager2();
        testApproaches(pman1, pman2);
    }
    
}

class Pair { // Not thread-safe
    
    private int x, y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public Pair() {}

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /**
     * 自增加非线程安全
     */
    public void incrementX() { x++; }
    
    public void incrementY() { y++; }

    @Override
    public String toString() {
        return "x: " + x + ", y: " + y;
    }
    
    public class PairValuesNotEqualException extends RuntimeException {
        public PairValuesNotEqualException() {
            super("Pair Values not equal: " + Pair.this);
        }
    }

    /**
     * Arbitrary invariant -- both variables must be equal:
     */
    public void checkState() {
        if (x != y) {
            throw new PairValuesNotEqualException();
        }
    }
}

/**
 * Protect a Pair inside a thread-safe class:
 * 一些功能在基类中实现 并且其一个或多个抽象方法在派生类定义 这种结构在设计模式中称为模板方法
 * 模板方法increment()
 */
abstract class PairManager {
    AtomicInteger checkCounter = new AtomicInteger(0);
    protected Pair p = new Pair();
    private List<Pair> storage = 
            Collections.synchronizedList(new ArrayList<>());

    /**
     * 唯一公开的方法
     * 线程安全
     * @return Pair
     */
    public synchronized Pair getPair() {
        // Make a copy to keep the original safe:
        return new Pair(p.getX(), p.getY());
    }

    /**
     * Assume this is a time consuming operation
     * @param p
     */
    protected void store(Pair p) {
        storage.add(p);
        try {
            TimeUnit.MILLISECONDS.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * x,y同时增加
     * 模板方法
     */
    public abstract void increment();
}

/**
 * Synchronized the entire method;
 *
 */
class PairManager1 extends PairManager {
    /**
     * synchronized不属于方法特征标的组成部分
     * 可以在覆盖方法时加上
     */
    @Override
    public synchronized void increment() {
        p.incrementX();
        p.incrementY();
        store(getPair());
    }
}

class PairManager2 extends PairManager {

    @Override
    public void increment() {
        Pair temp;
        synchronized (this) {
            p.incrementX();
            p.incrementY();
            temp = getPair();
        }
        store(temp);
    }
}

/**
 * Synchronize the entire method
 */
class ExplicitPairManager1 extends PairManager {
    private Lock lock = new ReentrantLock();
    @Override
    public synchronized void increment() {
        lock.lock();
        try {
            p.incrementX();
            p.incrementY();
            store(getPair());
        } finally {
            lock.unlock();
        }
    }
}

/**
 * Use a critical section
 */
class ExplicitPairManager2 extends PairManager {
    private Lock lock = new ReentrantLock();
    @Override
    public void increment() {
        Pair temp;
        lock.lock();
        try {
            p.incrementX();
            p.incrementY();
            temp = getPair();
        } finally {
            lock.unlock();
        }
        store(temp);
    }
}

class PairManipulator implements Runnable {
    private PairManager pm;
    public PairManipulator(PairManager pm) {
        this.pm = pm;
    }

    @Override
    public void run() {
        while (true) {
            pm.increment();
        }
    }

    @Override
    public String toString() {
        return "Pair: " + pm.getPair() + " checkCounter = " +  pm.checkCounter.get();
    }
}

class PairChecker implements Runnable {
    private PairManager pm;
    public PairChecker(PairManager pm) {
        this.pm = pm;
    }
    @Override
    public void run() {
        while (true) {
            pm.checkCounter.incrementAndGet();
            pm.getPair().checkState();
        }
    }
}


