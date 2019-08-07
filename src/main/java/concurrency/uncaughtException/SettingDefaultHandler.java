package concurrency.uncaughtException;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 直接在Thread类设置一个静态域 将错误处理器设置为默认的未捕获的异常处理器
 *
 * @author crystal303
 */
public class SettingDefaultHandler {
    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        ExecutorService exec = Executors.newSingleThreadExecutor();
        exec.execute(new ExceptionThread2());
        exec.shutdown();
    }
}
