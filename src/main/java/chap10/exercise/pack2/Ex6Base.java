package chap10.exercise.pack2;

import chap10.exercise.pack1.Ex6Interface;

public class Ex6Base {
    protected class ExBaseInner implements Ex6Interface {
        @Override
        public String say() { return "Hi"; }

        public ExBaseInner() {}
    }
}
