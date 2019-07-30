package chap16;

import chap16.generator.Generated;

import java.util.Arrays;
import java.util.Collections;

public class Reverse {
    public static void main(String[] args) {
        CompType[] a =
                Generated.array(CompType.class, CompType.generator(), 12);
        System.out.println("before sorting");
        System.out.println(Arrays.toString(a));
        Arrays.sort(a, Collections.reverseOrder());
        System.out.println("after sorting");
        System.out.println(Arrays.toString(a));
    }
}
