package chap12.exercise;

public class Ex5 {
    private static int[] ia = new int[2];
    static int x = 5;

    public static void main(String[] args) {
        while (true) {
            try {
                ia[x] = 10;
                System.out.println(ia[x]);
                break;
            } catch (IndexOutOfBoundsException e) {
                System.err.println("Caught IndexOutOfBoundsException.");
                e.printStackTrace();
                x--;
            } finally {
                System.out.println("Are we done yet?");
            }
            System.out.println("Now, we`re done.");
        }
    }
}
