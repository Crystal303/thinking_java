package chap11.exercise;

import java.util.ArrayList;
import java.util.List;

class Tester {
    public static int count = 0;
    private int id = count++;

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}

public class Ex7 {
    public static void main(String[] args) {
        Tester[] t = new Tester[10];
        for(int i = 0; i < t.length; i++) {
            t[i] = new Tester();
        }
        List<Tester> lt = new ArrayList<>();
        for (Tester x :
             t) {
            lt.add(x);
        }
        System.out.println("List of Tester: " + lt);
        List<Tester> sub = lt.subList(2, 6);
        System.out.println("list of Tester: " + lt);
        System.out.println("subList: " + sub);
        lt.removeAll(sub);
        List<Tester> copy = new ArrayList<>(lt);
        System.out.println("copy: " + copy);
        //! copy.removeAll(sub);
        lt = copy;
        System.out.println("list of Tester: " + lt);

    }
}
