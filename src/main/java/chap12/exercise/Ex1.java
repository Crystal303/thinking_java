package chap12.exercise;

class Exception1 extends Exception {
    public Exception1(String msg) {
        super(msg);
        System.out.println("Exception1 (String msg)");
    }
}

public class Ex1 {
    public static void f() throws Exception1 {
        System.out.println("Throwing Exception1 from f().");
        throw new Exception1("From f()");
    }

    public static void main(String[] args) {
        try {
            f();
        } catch (Exception1 exception1) {
            exception1.printStackTrace(System.out);
        } finally {
            System.out.println("Made it to finally.");
        }
    }

}
