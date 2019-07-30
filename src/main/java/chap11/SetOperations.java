package chap11;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SetOperations {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        Collections.addAll(set, "A B C D E F G H I J K L".split(" "));
        set.add("M");
        assert set.contains("A");
        Set<String> setSub = new HashSet<>();
        Collections.addAll(setSub, "H I J K".split(" "));
        assert set.contains(setSub);
        setSub.remove("H");
        System.out.println(setSub);
        set.removeAll(setSub);
        System.out.println(set);

    }
}
