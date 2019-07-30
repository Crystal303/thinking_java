package chap10.exercise;

public class Outer7 {
    private int oi = 1;
    private void hi() { System.out.println("Outer hi"); }
    class Inner {
        void modifyOuter() {
            oi *= 2;
            hi();
        }
    }

    public void showOi() {
        System.out.println(oi);
    }

    void testInner() {
        Inner in = new Inner();
        in.modifyOuter();
    }

    public static void main(String[] args) {
        Outer7 outer7 = new Outer7();
        outer7.showOi();
        outer7.testInner();
        outer7.showOi();
    }
}
