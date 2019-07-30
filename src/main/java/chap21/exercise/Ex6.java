package chap21.exercise;

import java.util.*;
import java.util.concurrent.*;

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
