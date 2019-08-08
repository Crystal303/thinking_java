package concurrency.interrupt;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author crystal303
 *
 * 解决阻塞的线程 行之有效 略显笨拙
 * 关关闭任务在其上发生阻塞的底层资源
 */
public class CloseResource {
    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        ServerSocket server = new ServerSocket(8888);
        InputStream socketInput =
                new Socket("localhost", 8888).getInputStream();
        exec.execute(new IOBlocked(socketInput));
        exec.execute(new IOBlocked(System.in));
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("Shutting down all threads");
        exec.shutdownNow();
        System.out.println("Closing " + socketInput.getClass().getName());
        // Releases blocked thread
        socketInput.close();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Closing " + System.in.getClass().getName());
        // Releases blocked thread
        System.in.close();
    }
}
