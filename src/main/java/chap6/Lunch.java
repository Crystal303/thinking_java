package chap6;

class Soup1 {
    private Soup1(){}
    public static Soup1 makeSoup() {
        return new Soup1();
    }

    public void f1() {}
}

class Soup2 {
    private Soup2(){}
    private static Soup2 ps1 = new Soup2();
    public static Soup2 access() {
        return ps1;
    }

    public void f1() {}
}

public class Lunch {
    void testPrivate() {
        // Soup1 soup1 = new Soup1();
    }

    void testStatic() {
        Soup1.makeSoup().f1();
    }

    void testSingleton() {
        Soup2.access().f1();
    }
}

