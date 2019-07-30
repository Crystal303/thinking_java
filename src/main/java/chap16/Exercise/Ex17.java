package chap16.Exercise;

import chap16.generator.Generated;
import chap16.generator.Generator;

import java.math.BigDecimal;
import java.util.Arrays;

class BigDecimalGenerator implements Generator {
    private BigDecimal bd = new BigDecimal(0.0);

    @Override
    public Object next() {
        return bd = bd.add(new BigDecimal(1.0));
    }
}

public class Ex17 {
    public static void main(String[] args) {
        BigDecimal[] bda1 = new BigDecimal[4];
        Generated.array(bda1, new BigDecimalGenerator());
        System.out.println(Arrays.toString(bda1));

        BigDecimal[] bda2 = Generated.array(BigDecimal.class,
                new BigDecimalGenerator(), 5);
        System.out.println(Arrays.toString(bda2));
    }
}
