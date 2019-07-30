package chap18.exercise;

import chap18.BinaryFile;

import java.io.*;
import java.util.*;


/**
 * 对文件中所有字节的次数进行计数
 * BinaryFile 和 Map<Byte, Integer>
 * @author crystal303
 */
public class ByteCounter19 {
    public static void main(String[] args) throws IOException {
        String fileName = "./src/main/java/chap18/exercise/ByteCounter19.java";
        // Array of all bytes in file;
        byte[] ba = BinaryFile.read(fileName);
        // Set of unique Bytes in file;
        Set<Byte> byteSet = new TreeSet<>();
        for (Byte b : ba) {
            byteSet.add(b);
        }
        // List of all Bytes in file:
        List<Byte> byteList = new ArrayList<>();
        for (Byte b : ba) {
            byteList.add(b);
        }
        Map<Byte, Integer> byteMap = new HashMap<>();
        for (Byte b : byteSet) {
            int count = 0;
            for (Byte d : byteList) {
                if (b.equals(d)) {
                    ++count;
                }
            }
            byteMap.put(b, count);
        }

        // second
        Map<Byte, Integer> map2 = new HashMap<>();
        for (Byte b : ba) {
            map2.put(b, map2.get(b) == null ? 1 : map2.get(b) + 1 );
        }
        System.out.println();
        System.out.println(byteMap);
        System.out.println(map2);
    }
}
