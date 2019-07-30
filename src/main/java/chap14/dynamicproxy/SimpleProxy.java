package chap14.dynamicproxy;

import java.util.Date;

public class SimpleProxy implements Interface {
    private Interface proxied;
    private static int doCount = 0;
    private static int sECount = 0;

    SimpleProxy(Interface proxied) {
        this.proxied = proxied;
    }
    @Override
    public void doSomething() {
        long timeIn = System.currentTimeMillis();
        System.out.println("SimpleProxy doSomething " +
                doCount + ": " + timeIn + " msecs");
        ++doCount;
        proxied.doSomething();
        System.out.println("Call-return time = " +
                (System.currentTimeMillis() - timeIn) + " msecs");
    }

    @Override
    public void doSomethingElse(String arg) {
        System.out.println("SimpleProxy somethingElse " +arg);
        proxied.doSomethingElse("arg");
    }
}
