package chap10;

interface A {}
interface B {}

class X implements A,B {}

class Y implements A {
    B makeB() {
        return new B(){};
    }
}

/**
 * @author crystal303
 * 初步探究使用内部类的重要性
 *
 */
public class MultiInterfaces {
    static void takeA(A a) {}
    static void takeB(B b) {}

    public static void main(String[] args) {
        X x = new X();
        Y y = new Y();

        takeA(x);
        takeB(x);

        takeA(y);
        takeB(y.makeB());
    }
}
