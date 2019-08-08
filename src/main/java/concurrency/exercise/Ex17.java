package concurrency.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 创建一个辐射计数器 可以具有任意数量的传感器
 *
 * @author crystal303
 */
public class Ex17 {
    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new Sensor(i));
        }
        TimeUnit.SECONDS.sleep(4);
        // 终结
        Sensor.cancel();
        exec.shutdown();
        if (!exec.awaitTermination(100, TimeUnit.MILLISECONDS)) {
            System.out.println("Some tasks were not terminated");
        }
        System.out.println("Total: " + Sensor.getTotalCount());
        System.out.println("Sum of sensors: " + Sensor.sumSensors());
    }
}

class RadCount {
    private int count = 0;
    private Random rand = new Random();
    public synchronized int increment() {
        int temp = count;
        if (rand.nextBoolean()) {
            Thread.yield();
        }
        count = ++temp;
        return count;
    }
    public synchronized int value() {
        return count;
    }
}

class Sensor implements Runnable {
    private static RadCount count = new RadCount();
    private static List<Sensor> sensors = new ArrayList<>();
    private int number = 0;
    /**
     * doesn`t need synchronization to read:
     */
    private final int id;
    private static volatile boolean canceled = false;

    public Sensor(int id) {
        this.id = id;
        // Keep this task in a list. Also prevents
        // garbage collection of dead tasks
        sensors.add(this);
    }

    /**
     * Atomic operation on a volatile field
     */
    public static void cancel() {
        canceled = true;
    }

    @Override
    public void run() {
        while (!canceled) {
            synchronized (this) {
                ++number;
            }
            System.out.println(this + " Total: " + count.increment());
            try {
                TimeUnit.MILLISECONDS.sleep(25);
            } catch (InterruptedException e) {
                System.out.println("sleep interrupted");

            }
        }
        System.out.println("Stopping " + this);
    }

    public synchronized int getValue() {
        return number;
    }

    @Override
    public String toString() {
        return "Sensor " + id + ": " + getValue();
    }

    public static int getTotalCount() {
        return count.value();
    }

    public static int sumSensors() {
        int sum = 0;
        for (Sensor s : sensors) {
            sum += s.getValue();
        }
        return sum;
    }
}
