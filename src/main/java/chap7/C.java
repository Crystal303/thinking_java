package chap7;

class A {
    A() {
        System.out.println("A()");
    }
}

class B extends A {
    B() { System.out.println("B()"); }
}

public class C extends A {
    B b = new B();

    public static void main(String[] args) {
        C c = new C();
    }
}
