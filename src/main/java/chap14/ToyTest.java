package chap14;

import com.sun.istack.internal.NotNull;

/**
 * 如何恰当的获取Class对象的引用
 * getSuperclass()方法查询基类
 *
 * obj.getClass()的使用
 *
 * @author crystal303
 */
public class ToyTest {
    static void printInfo(@NotNull Class cc) {
        System.out.println("Class name: " +  cc.getName() +
                " is interface? [" + cc.isInterface() + "]");
        System.out.println("Simple name: " + cc.getSimpleName());
        System.out.println("Canonical name : " + cc.getCanonicalName());
    }

    public static void main(String[] args) {
        Class c = null;

        try {
            c = Class.forName("chap14.FancyToy");
        } catch (ClassNotFoundException e) {
            System.out.println("Can`t find FancyToy");
        }
        System.out.println(c);

        for (Class face :
                c.getInterfaces()) {
            printInfo(face);
        }
        Class up = c.getSuperclass();
        Object obj = null;
        try {
            obj = up.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        printInfo(obj.getClass());
    }
}

interface HasBatteries{}
interface Waterproof{}
interface Shoots{}

class Toy {
    Toy() {}
    Toy(int i) {
    }
}

class FancyToy extends Toy
implements HasBatteries, Waterproof, Shoots {
    FancyToy() { super(1); }
}
