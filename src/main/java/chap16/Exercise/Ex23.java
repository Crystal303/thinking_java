package chap16.Exercise;

import chap16.generator.Generated;
import chap16.generator.RandomGenerator;

import java.util.Arrays;
import java.util.Collections;

public class Ex23 {
    public static void main(String[] args) {
        Integer[] ia = Generated.array(new Integer[12],
                new RandomGenerator.Integer(10));
        System.out.println(Arrays.toString(ia));
        System.out.println("sort");
        Arrays.sort(ia, Collections.reverseOrder());
        System.out.println(Arrays.toString(ia));

    }
}
