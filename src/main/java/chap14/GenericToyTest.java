package chap14;

/**
 * 泛化的Class引用
 *
 * @author crystal303
 */
public class GenericToyTest {
    public static void main(String[] args) throws Exception {
        Class<chap14.FancyToy> ftClass = FancyToy.class;

        // Produces exact type
        FancyToy fancyToy = ftClass.newInstance();

        Class<? super FancyToy> up = ftClass.getSuperclass();
        Object obj = up.newInstance();
    }
}
