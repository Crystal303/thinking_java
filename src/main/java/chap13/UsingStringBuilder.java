package chap13;

import java.util.Random;

public class UsingStringBuilder {
    public static Random rand = new Random();

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < 25; i++) {
            result.append(rand.nextInt(100));
            result.append(", ");
        }
        result.delete(result.length() - 2, result.length());
        result.append("]");
        return result.toString();
    }

    public static void main(String[] args) {
        UsingStringBuilder usb = new UsingStringBuilder();
        System.out.println(usb.toString());
        String b = "abcd";
        b = b.concat("liangliang");
        System.out.println(b + b.indexOf("a",4));

    }
}
