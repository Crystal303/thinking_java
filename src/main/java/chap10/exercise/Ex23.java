package chap10.exercise;

interface U {
    void f();
    void g();
    @Override
    String toString();
}

class A {
    public U getU() {
        return new U() {
            @Override
            public void f() {
                System.out.println("Inside f()");
            }

            @Override
            public void g() {
                System.out.println("Inside g()");
            }

            @Override
            public String toString() { return "I`m a U"; }
        };
    }
}

class B {
    private U[] us;
    public B(int num) {
        us = new U[num];
    }

    public void addU(U u) {
        for (int i = 0; i < us.length; i++) {
            if (us[i] == null) {
                us[i] = u;
                break;
            }
        }
    }

    public void eraseU(int i) {
        us[i] = null;
    }

    public void testUs() {
        for (U u:
             us) {
            u.f();
            u.g();
            u.toString();
        }
    }

    public void showUs() {
        for(U u : us) {
            if (u != null) {
                System.out.println(u.toString());
            } else {
                System.out.println("I`m null");
            }
        }
    }
}

public class Ex23 {
    public static void main(String[] args) {
        int n = 3;
        B b = new B(n);
        for (int i = 0; i < n; i++) {
            b.addU(new A().getU());
        }

        b.showUs();
        b.testUs();
        b.eraseU(0);
        b.eraseU(1);
        b.showUs();
    }
}
