package chap16;

import chap16.generator.Generated;
import chap16.generator.RandomGenerator;

import java.util.Arrays;

/**
 * 测试版本2 Arrays.sort()
 * @author crystal303
 */
public class AlphabeticSearch {
    public static void main(String[] args) {
        String[] sa = Generated.array(new String[30],
                new RandomGenerator.String(5));
        Arrays.sort(sa, String.CASE_INSENSITIVE_ORDER);
        System.out.println(Arrays.toString(sa));
        int index = Arrays.binarySearch(sa, "HxxHv", String.CASE_INSENSITIVE_ORDER);
        System.out.println("Index: " + index + "\n" + sa[index]);
    }
}
