package chap21;

public class MainThread {
    public static void main(String[] args) {
/*        LiftOff launch = new LiftOff();
        Thread t = new Thread(launch);
        t.start();*/
        // launch.run();

        for (int i = 0; i < 2; i++) {
            new Thread(new LiftOff()).start();
        }
        System.out.println("Waiting for LiftOff");
    }
}
