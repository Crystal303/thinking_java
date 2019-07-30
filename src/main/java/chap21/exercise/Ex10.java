package chap21.exercise;

import java.util.concurrent.*;

class Ex10Fibonacci implements Callable<Integer> {
    private Integer n = 0;
    ExecutorService exec = Executors.newSingleThreadExecutor();

    public Future<Integer> runTask(Integer n) {
        this.n = n;
        return exec.submit(this);
    }

    private int fib(int n) {
        if (n < 2) {
            return 1;
        }
        return fib(n-1) + fib(n-2);
    }

    @Override
    public Integer call() {
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += fib(i);
        }
        return result;
    }
}

public class Ex10 {
    public static void main(String[] args) {
        Ex10Fibonacci fib = new Ex10Fibonacci();
        for (int i = 0; i < 15; i++) {
            System.out.println("Sum of first" + i +
                    " Fibonacci numbers = ");
            try {
                System.out.println(fib.runTask(i).get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } finally {
                fib.exec.shutdown();
            }
        }
    }
}
