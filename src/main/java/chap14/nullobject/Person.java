package chap14.nullobject;

/**
 * 没有实际的人
 * 可以用instanceof 来探测泛化的Null还是更具体的NullPerson
 *
 * @author crystal303
 */
public class Person {
    public final String first;
    public final String last;
    public final String adderss;

    // etc.
    public Person(String first, String last, String adderss) {
        this.first = first;
        this.last = last;
        this.adderss = adderss;
    }

    @Override
    public String toString() {
        return "Person: " + first + " " + last + " " + adderss;
    }

    public static class NullPerson extends Person implements Null {

        public NullPerson() {
            super("None", "None", "None");
        }

        @Override
        public String toString() {
            return "NullPesron";
        }

    }

    /**
     * 通常 空对象都是单例
     * 静态final块创建
     */
    public static final Person NULL = new NullPerson();

}
