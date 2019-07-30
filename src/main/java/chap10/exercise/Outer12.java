package chap10.exercise;

interface Inner12 {
    void modifyOuter();
}

public class Outer12 {
    private int oi = 1;
    private void hi() {
        System.out.println("Outer hi");
    }

    public Inner12 inner() {
        return new Inner12() {
            @Override
            public void modifyOuter() {
                oi *= 2;
                hi();
            }
        };
    }

    public void showoi() { System.out.println(oi); }

    public static void main(String[] args) {
        Outer12 out = new Outer12();
        out.showoi();
        out.inner().modifyOuter();
        out.showoi();
    }
}
