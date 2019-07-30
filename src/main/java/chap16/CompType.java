package chap16;

import chap16.generator.Generated;
import chap16.generator.Generator;

import java.util.Arrays;
import java.util.Random;

public class CompType implements Comparable<CompType> {
    int i;
    int j;
    private static int count = 1;
    public CompType(int n1, int n2) {
        i = n1;
        j = n2;
    }

    @Override
    public String toString() {
        String result = "[i = " + i + ", j = " + j + "]";
        if (count++ % 3 == 0) {
            result +=  "\n";
        }
        return result;
    }

    @Override
    public int compareTo(CompType rv) {
        return  (i < rv.i) ? -1 : (i == rv.i ? 0 : 1);
    }

    private static Random r = new Random(47);
    public static Generator<CompType> generator() {
        return new Generator<CompType>() {
            @Override
            public CompType next() {
                return new CompType(r.nextInt(100), r.nextInt(100));
            }
        };
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof CompType) {
            CompType ct = (CompType)o;
            if (ct.i == i && ct.j == j) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CompType[] a =
                Generated.array(new CompType[48], generator());
        System.out.println("before sorting ");
        System.out.println(Arrays.toString(a));
        Arrays.sort(a);
        System.out.println("after sorting");
        System.out.println(Arrays.toString(a));
    }
}
