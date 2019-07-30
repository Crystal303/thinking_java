package chap16.generator;

import java.util.ArrayList;

public class Generated {
    /**
     * 接受一个已有的数组, 并使用某个Generator去填充它
     * @param a
     * @param gen
     * @param <T>
     * @return
     */
    public static <T> T[] array(T[] a, Generator<T> gen) {
        return new CollectionData<T>(gen, a.length).toArray(a);
    }

    /**
     * 接收一个Class对象, 一个Generator和所需的元素数量, 创建一个新数组, 使用Generatro填充它.
     * 只能是Object类型
     * @param type
     * @param gen
     * @param size
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T[] array(Class<T> type, Generator<T> gen, int size) {
        T[] a = (T[])java.lang.reflect.Array.newInstance(type, size);
        return new CollectionData<T>(gen, size).toArray(a);
    }


    private static class CollectionData<T> extends ArrayList<T> {

        public CollectionData(Generator<T> gen, int quantity) {
            for (int i = 0; i < quantity; i++) {
                add(gen.next());
            }
        }

        /**
         * A generic convenience method
         * @param gen
         * @param quantity
         * @param <T>
         * @return
         */
        public static <T> CollectionData<T> list(Generator<T> gen, int quantity) {
            return new CollectionData<>(gen, quantity);
        }
    }
}
