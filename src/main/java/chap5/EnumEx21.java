package chap5;

public class EnumEx21 {
    public enum Bills {
        ONE, FIVE, TEN, TWENTY, FIFTY, HUNDRED
    }

    public static void main(String[] args) {
        for (Bills b :
                Bills.values()) {
            System.out.println(b + ", ordinal " + b.ordinal());
        }
    }

}

