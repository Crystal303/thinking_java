package others;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * test List语法糖
 * @author crystal303
 */
public class TestList {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,3,4,45);
        List list2 = Arrays.asList( new Integer[] {
                Integer.valueOf(1), Integer.valueOf(2),
                Integer.valueOf(3), Integer.valueOf(4)
        });
        int sum = 0;
        for(Iterator localIterator = list2.iterator(); localIterator.hasNext();) {
            int i = ((Integer) localIterator.next()).intValue();
            sum += i;
        }
        System.out.println(sum);
    }
}
