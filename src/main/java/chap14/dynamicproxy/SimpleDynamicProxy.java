package chap14.dynamicproxy;

import java.lang.reflect.*;

/**
 * Java动态代理 实现
 * 动态地创建代理并动态的处理所代理方法的调用
 * 动态代理上所做的所有调用都会被重定向到单一的处理器上
 * 工作： 揭示调用的类型并确定相应的对策
 *
 * @author crystal303
 */
public class SimpleDynamicProxy {
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.doSomethingElse("bonobo");
    }

    public static void main(String[] args) {
        RealObject real = new RealObject();
        consumer(new SimpleProxy(real));
        System.out.println();
        // Insert a proxy and call again: 通过调用静态方法Proxy.newProxyInstance()创建动态代理
        // 一个类加载器 一个希望代理实现的接口列表 一个InvocationHandler接口的实现类
        Interface proxy = (Interface) Proxy.newProxyInstance(
                Interface.class.getClassLoader(),
                new Class[]{ Interface.class },
                new DynamicProxyHandler(new SimpleProxy(real))
        );
        consumer(proxy);

    }

}

class DynamicProxyHandler implements InvocationHandler {
    private Object proxied;
    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 执行被代理的操作 中介任务
        System.out.println("**** proxy: " + proxy.getClass()
        + ", method: " + method + ", args: " + args);
        System.out.println();
        // System.out.println("proxy: " + proxy);
        if (args != null) {
            System.out.println("print args");
            for (Object arg : args) {
                System.out.println(" " + arg);
            }
        }
        // 对接口的调用重定向为对代理的调用
        // 通过传入其他的参数 来过滤某些方法调用
        return method.invoke(proxied, args);
    }
}

