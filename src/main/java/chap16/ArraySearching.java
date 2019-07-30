package chap16;

import chap16.generator.CovertTo;
import chap16.generator.Generated;
import chap16.generator.Generator;
import chap16.generator.RandomGenerator;

import java.util.Arrays;

/**
 * Arrays.binarySearch()方法测试
 * @author crystal303
 */
public class ArraySearching {
    public static void main(String[] args) {
        Generator<Integer> gen =
                new RandomGenerator.Integer(1000);
        int[] a = CovertTo.primitive(Generated.array(new Integer[25],
                gen));
        Arrays.sort(a);
        while (true) {
            int t = gen.next();
            int location = Arrays.binarySearch(a, t);
            if (location >= 0) {
                System.out.println("Location of " + t + " is " +
                        location + ", a[" + location + "] = " + a[location]);
                break;
            }
        }
    }
}
