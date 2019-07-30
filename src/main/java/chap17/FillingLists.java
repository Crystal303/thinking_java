package chap17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class StringAddress {
    private String s;
    public StringAddress(String s) {
        this.s = s;
    }
    @Override
    public String toString() {
        return super.toString() + " " + s;
    }
}

/**
 * test Collections fill() nCopies()
 * @author crystal303
 */
public class FillingLists {
    public static void main(String[] args) {
        List<StringAddress> list = new ArrayList<>(
                Collections.nCopies(4, new StringAddress("hello"))
        );
        System.out.println(list);
        Collections.fill(list, new StringAddress("world"));
        System.out.println(list);
        list = Collections.nCopies(5, new StringAddress("peace"));
        System.out.println(list);


    }
}
