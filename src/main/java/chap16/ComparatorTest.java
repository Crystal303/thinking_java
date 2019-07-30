package chap16;

import chap16.generator.Generated;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class CompTypeComparator implements Comparator<CompType> {

    @Override
    public int compare(CompType o1, CompType o2) {
        return (o1.i < o2.i ? -1 : (o1.i == o2.i ? 0 : 1));
    }


    @Override
    public Comparator<CompType> reversed() {
        return Collections.reverseOrder();
    }

}

public class ComparatorTest {
    public static void main(String[] args) {
        CompType[] a =
            Generated.array(new CompType[48], CompType.generator());
        System.out.println("before sorting: ");
        System.out.println(Arrays.toString(a));
        Arrays.sort(a, new CompTypeComparator());
        System.out.println("after sorting: ");
        System.out.println(Arrays.toString(a));

        System.out.println("after reversed: ");
        Arrays.sort(a, new CompTypeComparator().reversed());
        System.out.println(Arrays.toString(a));
    }

}
