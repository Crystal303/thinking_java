package chap17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class CollectionMethods {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>();
        ((ArrayList<String>) c).add("ten");
        c.add("eleven");
        System.out.println(c);

        // Make an array from the List:
        Object[] array = c.toArray();
        // Make a String array from the List
        String[] str = c.toArray(new String[0]);
        System.out.println("str: " + Arrays.toString(str));
        // Find max and min elements: this means
        // different things depending on the way
        System.out.println("Collections.max(c) = " + Collections.max(c));
        System.out.println("Collections.min(c) = " + Collections.min(c));
        // Add a Collection to another Collection
        Collection<String> c2 = new ArrayList<>();
    }
}
