package concurrency;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * 希望在任务完成时能够返回值
 * Callabel是一种具有参数的泛型 类型参数表示是从方法call()返回的值
 * 必须使用ExecutorService.submit()调用它
 *
 * @author crystal303
 */
class TaskWithResult implements Callable<String> {
    private int id;
    public TaskWithResult(int i) {
        this.id = i;
    }

    @Override
    public String call() throws Exception {
        return "result of TaskWithResult " + id;
    }
}

/**
 * test1
 * submit()方法产生Future对象
 *
 *
 * @author crystal303
 */
public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            results.add(exec.submit(new TaskWithResult(i)));
        }
        for (Future<String> fs : results) {
            System.out.println("结果就绪？ " + fs.isDone());
            try {
                System.out.println(fs.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } finally {
                exec.shutdown();
            }
        }
    }
}
