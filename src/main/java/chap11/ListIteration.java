package chap11;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * list produce ListIterator
 * @author crystal303
 */
public class ListIteration {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(String.valueOf(i));
        }
        ListIterator lt = list.listIterator();
        while (lt.hasNext()) {
            System.out.print(lt.next() + ", " + lt.nextIndex() + ", " +
                    lt.previousIndex() + "; ");
        }
        System.out.println();
        while (lt.hasPrevious()) {
            System.out.print(lt.previous() + " ");
        }
        System.out.println();
        System.out.println(list);
        System.out.println(lt.next() + " " + lt.next());
        lt.set(String.valueOf(11));
        System.out.println(list);

    }
}
