package chap10.exercise;

class Outer {
    class Inner {
        Inner() {
            System.out.println("Outer.Inner()");
        }
    }
}

public class OtherOuter {
    public static void main(String[] args) {
        // must first create outer class object:
        Outer o = new Outer();
        Outer.Inner oi = o.new Inner();
    }
}
