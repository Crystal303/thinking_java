package chap14.dynamicproxy;

/**
 * 简单的代理
 *
 * @author crystal303
 */
public class SimpleProxyDemo {
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.doSomethingElse("bonobo");
    }

    public static void main(String[] args) {
        consumer(new RealObject());
        consumer(new SimpleProxy(new RealObject()));
        System.out.println();
        consumer(new SimpleProxy(new RealObject()));
    }
}