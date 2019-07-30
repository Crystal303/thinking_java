package chap3;

import java.math.BigInteger;

public class BigIntegerTest {
    public static void main(String[] args) {
        float f1 = 123.01f + 2.01f;
        System.out.println(f1);

        double f2 = 123.1 + 2.01;
        System.out.println(f2);

        BigInteger bigInteger = new BigInteger("123");
        BigInteger bigInteger1 = new BigInteger("999");
        BigInteger result = bigInteger.add(bigInteger1);
        System.out.println(result);

    }
}
