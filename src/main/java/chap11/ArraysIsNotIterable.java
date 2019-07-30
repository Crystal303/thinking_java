package chap11;

import java.util.Arrays;

public class ArraysIsNotIterable {
    static <T> void test(Iterable<T> ib) {
        for (T t :
                ib) {
            System.out.print(t + " ");
        }
    }

    public static void main(String[] args) {
        test(Arrays.asList(1, 2, 3));
        String[] strings = {"A", "B", "C"};
        //! test(strings);
        test(Arrays.asList(strings));
        for (String s:
             strings) {
            System.out.print(s + " ");

        }
    }
}
