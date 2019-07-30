package chap10;

class D {}
abstract class E {}

class Z extends D {
    E makeE() {
        return new E() {};
    }
}

/**
 * @author crystal303
 * 探究内部类实现多重继承的方式
 */
public class MultiImplementation {
    static void takeD(D d) {}
    static void takeE(E e) {}

    public static void main(String[] args) {
        Z z = new Z();
        takeD(z);
        takeE(z.makeE());
    }
}
