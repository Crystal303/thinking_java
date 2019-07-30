package chap10.exercise;

interface Ex13Interface {
    String say(String s);
}

public class Outer13 {
    Ex13Interface f() {
        return new Ex13Interface() {
            @Override
            public String say(String s) {
                return s;
            }
        };
    }

    public static void main(String[] args) {
        Outer13 o = new Outer13();
        System.out.println(o.f().say("Hi"));
    }
}
