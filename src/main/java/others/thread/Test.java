package others.thread;

public class Test {
    public static void main(String[] args) {
        Tickets t = new Tickets(10);
        new Producer(t).start();
        new Consumer(t).start();
    }
}
