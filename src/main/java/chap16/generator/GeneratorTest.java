package chap16.generator;

/**
 * 使用反射 测试Generator任何集合
 */
public class GeneratorTest {
    private static int size = 10;
    public static void test(Class<?> surroundingClass) {
        for(Class<?> type : surroundingClass.getClasses()) {
            System.out.print(type.getSimpleName()+ ": ");
            Generator<?> g = null;
            try {
                g = (Generator<?>) type.newInstance();
                for (int i = 0; i < size; i++) {
                    System.out.printf(g.next() + " ");
                }
                System.out.println();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        test(CountingGenerator.class);
        System.out.println();
        test(RandomGenerator.class);
    }
}
