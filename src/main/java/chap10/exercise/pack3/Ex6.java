package chap10.exercise.pack3;

import chap10.exercise.pack1.Ex6Interface;
import chap10.exercise.pack2.Ex6Base;

public class Ex6 extends Ex6Base {
    Ex6Interface getBaseInner() {
        return this.new ExBaseInner();
    }

    public static void main(String[] args) {
        Ex6 ex = new Ex6();
        System.out.println(ex.getBaseInner().say());
    }
}
