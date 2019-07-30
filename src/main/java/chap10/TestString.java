package chap10;

public class TestString {
    public static void main(String[] args) {
        String s = "abc";
        String t = new String("abc");
        System.out.println(s.intern());
        assert s.intern() == t.intern();
        assert s.equals(t) == true;
        assert s != t;
        // "abcd".intern();

        String t1 = new String();
        System.out.println(t1);
        System.out.println(t1 == null);

    }
}
