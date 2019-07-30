package chap10.exercise;

public class Outer3 {
    private String s;
    class Inner3 {
        Inner3() {
            System.out.println("Inner()");
        }

        @Override
        public String toString() {
            return s;
        }
    }

    Outer3(String s) {
        System.out.println("Outer3()");
        this.s = s;
    }

    Inner3 makerInner3() {
        return new Inner3();
    }

    public static void main(String[] args) {
        Outer3 o = new Outer3("Hi is risen");
        Inner3 i = o.makerInner3();
        System.out.println(i);
    }
}
