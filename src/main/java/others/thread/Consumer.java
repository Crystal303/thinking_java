package others.thread;

public class Consumer extends Thread {
    Tickets t = null;
    public Consumer(Tickets t) {
        this.t = t;
    }
    @Override
    public void run() {
        while (t.i < t.size) {
            t.sell();
        }
    }
}
