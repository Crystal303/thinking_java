package chap10;

public class InitialTest {

    {
        System.out.println("Inside {}");
        q = 2;
    }
    int q = 4;
    int p = 3;
    {
        System.out.println(p);
    }


    public static void main(String[] args) {
        InitialTest i = new InitialTest();
        System.out.println(i.q);
    }
}
