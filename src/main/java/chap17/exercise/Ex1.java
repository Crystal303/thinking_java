package chap17.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ex1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(1, 3, 4, 5, 66, 7));
        System.out.println("before shuffle: " + list);
        Collections.shuffle(list);
        System.out.println("after shuffle: " + list);
    }
}
