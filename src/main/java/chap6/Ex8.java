package chap6;

class A8 {
    A8(char c, int i) {
        System.out.println("A(char, int )");
    }
}

public class Ex8 extends A8{
    private char c;
    private int i;
    Ex8() {
        super('z', 3);
        System.out.println("Ex8()");
    }

    Ex8(char a, int j) {
        super(a, j);
        c = a;
        i = j;
        System.out.println("Ex8（char, int)");
    }

    public static void main(String[] args) {
        Ex8 ex1 = new Ex8();
        Ex8 ex2 = new Ex8('b', 2);
    }
}
