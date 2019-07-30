package chap5;

public class OverloadingVarargs {
    static void f(Character... args) {
        System.out.print("first");
        for (Character character : args
             ) {System.out.print(" " + character);

        }
        System.out.println();
    }

    static void f(Integer... args) {
        System.out.print("second");
        for (Integer integer:
             args) {System.out.print(" " + integer);
        }
        System.out.println();
    }

    static void f(Long... longs) {
        System.out.print("third");
    }

    public static void main(String[] args) {
        f('a', 'b', 'c');
        f(1);
        f(0L);
        //! f(); // 对f 的引用不明确；
    }
}
