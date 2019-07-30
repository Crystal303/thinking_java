package chap17;

import chap16.generator.CountingGenerator;
import chap16.generator.RandomGenerator;

/**
 * MapData.map() test
 * @author crystal303
 */
public class MapDataTest {
    public static void main(String[] args) {
        // Pair Generator
        System.out.println(MapData.map(
                new Letters(), 11
        ));
        // Two separate generators:
        System.out.println(MapData.map(
                new CountingGenerator.Character(),
                new RandomGenerator.String(3),
                8
        ));
        // A key Generator and a single value:
        System.out.println(MapData.map(
                new CountingGenerator.Character(),
                "Value", 6
        ));
        // An Iterable and a value Generator:
        System.out.println(MapData.map(
                new Letters(),
                new RandomGenerator.String(3)
        ));
        // An Iterable and a single value
        System.out.println(MapData.map(
                new Letters(), "Pop"
        ));
    }
}
