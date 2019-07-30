package chap17.hashcode;

/**
 * 土拨鼠
 *
 * @author crystal303
 */
public class Groundhog {
    protected int number;
    public Groundhog(int n) {
        number = n;
    }

    @Override
    public String toString() {
        return "Groundhog #" + number;
    }
}
