package others.thread;

public class Tickets {
    int size;
    /**
     * 存票序号
     */
    int number = 0;
    /**
     * 售票序号
     */
    int i = 0;
    /**
     * 是否有待售的票
     */
    boolean available = false;

    public Tickets(int size) {
        this.size = size;
    }

    public synchronized void put() {
        if (available) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Produce puts ticket: " + (++number));
        available = true;
        notify();
    }

    public synchronized void sell() {
        if (!available) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (i <= number) {
            System.out.println("Consumer buys ticket: " + (++i));
        }
        if (i == number) {
            available = false;
        }
        notify();
    }
}
