package chap16.generator;

import java.util.Arrays;

/**
 * 测试工具类方法 primitive
 * @author crystal303
 */
public class PrimitiveConversionDemonstration {
    public static void main(String[] args) {
        Integer[] a = Generated.array(Integer.class,
                new CountingGenerator.Integer(), 16);
        int[] b = CovertTo.primitive(a);
        System.out.println(Arrays.toString(b));

        boolean[] c = CovertTo.primitive(
                Generated.array(Boolean.class,
                new CountingGenerator.Boolean(), 16));
        System.out.println(Arrays.toString(c));
    }
}
