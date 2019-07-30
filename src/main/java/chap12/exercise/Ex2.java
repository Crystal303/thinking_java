package chap12.exercise;

public class Ex2 {
    public static Object o = null;

    public static void f(Object o){
        // leads to NullPointException
        try {
            System.out.println(o.toString());
        } catch (NullPointerException npe) {
            System.err.println("Caught NullPointerException");
            npe.printStackTrace();
        }
        try {
            o = 1;
            System.out.println(o.toString());
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        } finally {
            System.out.println("Got through it.");
        }


    }

    public static void main(String[] args) {
        f(o);
    }
}
