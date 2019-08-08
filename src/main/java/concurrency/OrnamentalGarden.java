package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 花园通过多个大门进入的总人数统计
 *
 * @author crystal303
 */
public class OrnamentalGarden {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new Entrance(i));
        }
        // Run for a while. then stop and collect the data:
        TimeUnit.SECONDS.sleep(3);
        // 发送static cancel()消息
        Entrance.cancel();
        exec.shutdown();
        // 等待每个任务结束 所有任务完成在超时时间达到之前结束 返回true 否则false
        if (!exec.awaitTermination(250, TimeUnit.MILLISECONDS)) {
            System.out.println("Some tasks were not terminated!");
        }
        System.out.println("Total: " + Entrance.getTotalCount());
        System.out.println("sum of Entrances: " + Entrance.sumEntrances());
    }
}

class Count {
    private int count = 0;
    private Random rand = new Random(47);
    /**
     * Remove the synchronized keyword to see counting fail;
     */
    public synchronized int increment() {
        int temp = count;
        // 设置大约一半时间 让步
        if (rand.nextBoolean()) {
            // Yield half the time
            Thread.yield();
        }
        return (count = ++temp);
    }

    public synchronized int value() {
        return count;
    }
}

class Entrance implements Runnable {
    /**
     * 使用单个的Count对象来跟踪花园参观者的主计数值
     * 使用静态域进行存储
     */
    private static Count count = new Count();
    private static List<Entrance> entrances =
            new ArrayList<>();
    /**
     * 维护一个本地值 包含通过某个特定入口的参观者的数量
     * 同时提供对count对象的双重检查
     */
    private int number;
    /**
     * Doesn`t need synchronization to read
     */
    private final int id;
    /**
     * 只会被读取和赋值
     * 在静态域 不会被其他域组一起被读取
     */
    private static volatile boolean canceled = false;

    /**
     * Atomic operation on a volatile field:
     */
    public static void cancel() {
        canceled = true;
    }
    public Entrance(int id) {
        this.id = id;
        // Keep this task in a list. Also prevents
        // garbage collection of dead tasks:
        entrances.add(this);
    }

    /**
     * 递增number和count对象 然后休眠100秒
     */
    @Override
    public void run() {
        while (!canceled) {
            synchronized (this) {
                ++number;
            }
            // synchronized (count) { 互斥同步
                System.out.println(this + " Total: " + count.increment());
            // }
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("sleep interrupted");
            }
        }
        System.out.println("stopping " + this);
    }

    public synchronized int getValue() {
        return number;
    }

    @Override
    public String toString() {
        return "Entrance " + id + ": " + getValue();
    }

    public static int getTotalCount() {
        return count.value();
    }

    public static int sumEntrances() {
        int sum = 0;
        for (Entrance entrance :
                entrances) {
            sum += entrance.getValue();
        }
        return sum;
    }
}
