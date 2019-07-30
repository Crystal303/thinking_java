package chap10.exercise;

public class Outer1 {
    class Inner {
        Inner(){
            System.out.println("Inner()");
        }
    }

    Outer1() {
        System.out.println("Outer1()");
    }

    Inner makerInner() {
        return new Inner();
    }

    public static void main(String[] args) {
        Outer1 o = new Outer1();
        Inner i = o.makerInner();
    }
}
