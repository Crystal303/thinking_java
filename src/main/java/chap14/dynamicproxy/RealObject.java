package chap14.dynamicproxy;

/**
 * 实现Iterface接口
 *
 * @author crystal303
 */
public class RealObject implements Interface {
    @Override
    public void doSomething() {
        System.out.println("doSomething");
    }

    @Override
    public void doSomethingElse(String arg) {
        System.out.println("doSomethingElse " + arg);
    }
}
