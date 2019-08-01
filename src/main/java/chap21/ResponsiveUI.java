package chap21;

/**
 * 创建有响应的UI
 *
 * @author crystal303
 */
class UnresponsiveUI {
    private volatile double d = 1;
    public UnresponsiveUI() throws Exception {
        while (d > 0) {
            d = d + (Math.PI + Math.E) / d;
        }
    }
}


public class ResponsiveUI extends Thread {
    private static volatile double d  = 1;
    public ResponsiveUI() {
        setDaemon(true);
        start();
    }

    @Override
    public void run() {
        while (true) {
            d = d + (Math.PI + Math.E);
        }
    }

    public static void main(String[] args) throws Exception {
        //! new UnresponsiveUI();
        new ResponsiveUI();
        double i = System.in.read();
        System.out.println(i);
    }
}

