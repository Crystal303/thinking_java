package chap11;

import java.util.*;

public class Statistics {
    public static Map<String, Integer> statistics(Collection<String> list) {
        Map<String, Integer> map = new HashMap<>();
        for (String s:
             list) {
            Integer freq = map.get(s);
            map.put(s, freq == null ? 1 : freq + 1);
        }
        return map;
    }

    public static void main(String[] args) {
        List<String> ls = new ArrayList<>();
        ls.add("靓靓c");
        ls.add("衣垣a");
        ls.add("垣衣b");
        ls.add("慧谊b");
        ls.add("靓靓c");
        Map map = statistics(ls);
        for (Object o:
                map.values()) {
            System.out.print(o + " ");
        }
        System.out.println();

        Set<Map.Entry> set = map.entrySet();
        System.out.println(set);

        for (Map.Entry me:
             set) {
            System.out.print(me.getKey() + ":" + me.getValue() + " ");
        }
        System.out.println();
        System.out.println(map);
    }
}
