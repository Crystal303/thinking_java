package concurrency.sharedresources;

import java.util.concurrent.TimeUnit;

/**
 * IntGenerator的一个实现类
 *
 * @author crystal303
 */
public class EvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;

    @Override
    public int next() {
        // Danger point here
        ++currentEvenValue;
        try {
            TimeUnit.NANOSECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator());
    }
}
