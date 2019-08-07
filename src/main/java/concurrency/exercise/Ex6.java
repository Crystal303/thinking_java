package concurrency.exercise;

import java.util.*;
import java.util.concurrent.*;

/**
 * 睡眠1至10秒随机数量的时间
 *
 * @author crystal303
 */
public class Ex6 implements Runnable {
    Random rand = new Random();

    @Override
    public void run() {
        int t = 1000 * rand.nextInt(10);
        try {
            TimeUnit.MILLISECONDS.sleep(t);
            System.out.println("Slept " + t/1000 + " seconds");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: enter a number");
        }
        if (args.length == 1) {
            int n = Integer.parseInt(args[0]);
            ExecutorService exec =
                    Executors.newCachedThreadPool();
            for (int i = 0; i < n; i++) {
                exec.execute(new Ex6());
            }
            exec.shutdown();
        }
    }
}
