package chap14;

/**
 * 验证Class对象的动态加载机制
 * 第一次对类静态成员的引用时载入
 * 类构造函数也是一个 类的静态方法!
 *
 * @author crystal303
 */
public class SweetShop {
    public static void main(String[] args) {
        System.out.println("inside main");
        new Candy();
        System.out.println("After creating Candy");
        try {
            Class.forName("chap14.Gum");
        } catch (ClassNotFoundException e) {
            System.out.println("类Gum未被动态载入");
        }
        System.out.println("After Class.froName(\"Gum\")");
        new Cookie();
        System.out.println("After creating Cookie");
/*        try {
            Class.forName("chap14.Cookie");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("类Cookie未被动态载入");
        }
        System.out.println("after Class.forName(\"Cookie\")");*/
    }
}

class Candy {
    static { System.out.println("loading Candy"); }
}

class Gum {
    static { System.out.println("loading Gum"); }
}

class Cookie {
    static { System.out.println("Loading Cookie");}
}



