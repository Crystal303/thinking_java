package chap14;

import chap14.reflect.A;
import chap14.reflect.SecretMaker;

import java.lang.reflect.Method;

/**
 * 反射调用
 *
 * @author crystal303
 */
public class Finder25 {
    public static void main(String[] args) throws Exception {
        A a = SecretMaker.makerSecret();
        System.out.println("a is of class type: " +
                a.getClass().getName());
        for (Method m : a.getClass().getDeclaredMethods()) {
            m.setAccessible(true);
            m.invoke(a);
        }
    }
}
