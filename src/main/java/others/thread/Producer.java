package others.thread;

public class Producer extends Thread {
    Tickets t = null;
    public Producer(Tickets t) {
        this.t = t;
    }
    @Override
    public void run() {
        while (t.number < t.size) {
            t.put();
        }
    }
}
