package chap16;

import java.util.Arrays;

public class CopyingArrays {
    public static void main(String[] args) {
        int[] i = new int[7];
        int[] j = new int[10];
        Arrays.fill(i, 47);
        Arrays.fill(j, 98);
        System.out.println("i = " + Arrays.toString(i));
        System.out.println("j = " + Arrays.toString(j));
        System.arraycopy(i, 0, j, 3, i.length);
        System.out.println("j = " + Arrays.toString(j));

        int[] k = new int[5];
        Arrays.fill(k, 103);
        System.out.println("k = " + Arrays.toString(k));
        System.arraycopy(i,0, k, 0,k.length);
        System.out.println("k = " + Arrays.toString(k));

        // Objects
        Integer[] u = new Integer[10];
        Integer[] v = new Integer[5];
        Integer in = new Integer(12);
        Arrays.fill(u, in);
        Arrays.fill(v, new Integer(99));
        System.out.println("u = " + Arrays.toString(u));
        System.out.println("v = " + Arrays.toString(v));
        System.arraycopy(v, 0, u, u.length/2, v.length);
        System.out.println("u = " + Arrays.toString(u));

    }
}
