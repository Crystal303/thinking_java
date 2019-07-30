package chap16;

/**
 * 牛顿迭代法 求平方根 x^2 - n --> x = (x + n/x) / 2
 * 公式 Xn+1 = Xn - f`(Xn)/f(Xn)
 * @author crystal303
 */
public class MySqrt {
    public static int mySqrt(int n) {
        long x = n;
        while (x * x > n) {
            x = (x + n/x) / 2;
        }
        return (int)x;
    }

    public static int mySqrt1(int n) {
        if (n == 0) {
            return 0;
        }
        long l = 1;
        long mid = n / 2;

        return (int)l;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(7));
        System.out.println(mySqrt(9));
        System.out.println(mySqrt(111));
        System.out.println(mySqrt(123));
        System.out.println(mySqrt(0));
        System.out.println(mySqrt(Integer.MAX_VALUE));
    }
}
