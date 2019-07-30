package chap17;

/**
 * 创建map对象 仅可读
 * @param <K>
 * @param <V>
 * @author crystal303
 */
public class Pair <K, V> {
    public final K key;
    public final V value;
    public Pair(K k, V v) {
        key = k;
        value = v;
    }
}
