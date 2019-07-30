package chap7;

/**
 * 代理是在代理类组合成员对象 私有化 封装公开新的方法
 */

class Cleanser {
    private String s = "Cleanser";
    public void append(String a) { s += a; }
    public void dilute() { append(" dilute()"); }
    public void apply() { append(" apply()"); }
    public void scrub() { append(" scrub()"); }
    @Override
    public String toString() { return s; }
    public static void main(String[] args) {
        Cleanser x = new Cleanser();
        System.out.print(x);
    }
}

public class DetergentDelegation {
    private String s = "DetergentDelegation";
    Cleanser c = new Cleanser();
    public void append(String a) { s += a; }
    // two methods delegated entirely to Cleanser c:
    public void dilute() {
        c.dilute();
    }
    public void apply() {
        c.apply();
    }
    // method delegated in part to Cleanser c:
    public void scrub() {
        append(" DetergentDelegation.scrub()");
        c.scrub();
    }
    public void foam() { append(" foam()"); }
    @Override
    public String toString() { return s + " " + c; }
    public static void main(String[] args) {
        DetergentDelegation x = new DetergentDelegation();
        x.dilute();
        x.apply();
        x.scrub();
        x.foam();
        System.out.print(x);
        System.out.print("Testing base class:");
        Cleanser.main(new String[]{});
    }
}
