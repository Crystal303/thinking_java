package chap21.exercise;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 使得计算所有斐波那契数字的数值总和的任务成为Callable
 *
 * @author crystal303
 */
public class Ex5 {
    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<Integer>> result = new ArrayList<>();
        for (int i = 10; i < 25; i++) {
            result.add(exec.submit(new TaskWithResult(i)));
        }
        for (Future<Integer> fs:
                result){
            System.out.println("isDone() " + fs.isDone());
            System.out.println(fs.get());
        }
        exec.shutdown();
    }
}

class TaskWithResult implements Callable<Integer> {
    private int n = 0;
    TaskWithResult(int n) {
        if (0 <= n) {
            this.n = n;
        }
    }

    @Override
    public Integer call() throws Exception {
        return fib(n);
    }

    private Integer fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n-1) + fib(n-2);
    }

/*    public static void main(String[] args) {
        System.out.println(new TaskWithResult(7).fib(7));
    }*/

}
