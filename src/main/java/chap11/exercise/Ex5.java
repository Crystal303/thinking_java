package chap11.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ex5 {
    public static List<Integer> listOfRandInteger(int length, int n) {
        Random rand = new Random();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < length; i++) {
            list.add(rand.nextInt(n));
        }
        return list;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        List<Integer> list = listOfRandInteger(7, 10);
        System.out.println("1: " + list);
        Integer h = new Integer(rand.nextInt(10));
        list.add(h);
        assert list.contains(h);
        list.remove(h);
        Integer p  = list.get(2);
        assert list.indexOf(p) == 2;
        Integer cy = new Integer(rand.nextInt(10));
        List<Integer> sub = list.subList(1, 4);
        System.out.println("subList: " + sub);
        assert list.contains(sub) == true;
        list.addAll(2, sub);
        System.out.println("subList: " + list);
        Object[] o = list.toArray();
        list.clear();
        assert list.isEmpty() == true;
        System.out.println(o[3]);
        Integer[] ia = list.toArray(new Integer[3  ]);
        for (Integer i :
                ia) {
            System.out.println(i);
        }
    }
}
