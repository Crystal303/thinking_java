package chap16.generator;

import java.util.Arrays;

public class TestGenerated {
    public static void main(String[] args) {
        Integer[] a = {9, 8, 7, 6, 5};
        System.out.println(Arrays.toString(a));
        a = Generated.array(a, new CountingGenerator.Integer());
        System.out.println(Arrays.toString(a));

        Integer[] b = Generated.array(Integer.class,
                new CountingGenerator.Integer(), 15);
        System.out.println(Arrays.toString(b));

        String[] c = Generated.array(String.class, new CountingGenerator.String(), 15);
        System.out.println(Arrays.toString(c));
    }
}
