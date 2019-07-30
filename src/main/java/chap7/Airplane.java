package chap7;

class Engine {
    private String s;
    Engine() {
        System.out.println("Engine()");
        s = "Constructed";
    }
    @Override
    public String toString() {return s;}
}

public class Airplane {
    private String fuselage, wings, tail;
    private Engine e;
    public Airplane() {
        System.out.println("Inside Airplane");
        fuselage = "Body";
        wings = "Airfoils";
        tail = "Empennage";
    }

    @Override
    public String toString() {
        if(e == null) {
            e = new Engine();
        } // lazy（Delayed) initialization
        return "fuselage = " + fuselage + ", " +
                "wings = " + wings + ", " +
                "tail = " + tail + ", " +
                "Engine = " + e;
    }

    public static void main(String... args) {
        Airplane N1234 = new Airplane();
        System.out.println(N1234.getClass());
        System.out.println(N1234);
    }
}
