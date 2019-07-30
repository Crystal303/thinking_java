package chap10.exercise;

public class Outer8 {
    class Inner {
        private int ii1 = 1;
        private int ii2 = 2;
        private void showIi2() {
            System.out.println(ii2);
        }
        private void hi() {
            System.out.println("Inner hi");
        }
        // Need to create objects to access private elements of Inner:
    }

    int oi = new Inner().ii1;
    void showOi() { System.out.println(oi); }
    void showIi2() { new Inner().showIi2(); }
    void outerHi() { new Inner().hi(); }

    public static void main(String[] args) {
        Outer8 outer8 = new Outer8();
        outer8.showOi();
        outer8.showIi2();
        outer8.outerHi();
    }
}
