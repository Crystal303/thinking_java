package chap18;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class TextFile extends ArrayList<String> {
    /**
     * Read a file as a single String.
     * @param filename
     * @return
     */
    public static String read(String filename) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(
                    new FileReader(
                            new File(filename).getAbsolutePath()
                    )
            );

            try {
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            } finally {
                in.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }

    /**
     * Write a single file in one method call:
     * @param filename
     * @param text
     */
    public static void write(String filename, String text) {
        try {
            PrintWriter out = new PrintWriter(
                    new File(filename).getAbsolutePath()
            );
            try {
                out.print(text);
            } finally {
                out.close();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public TextFile(String filename, String splitter) {
        super(Arrays.asList(
                read(filename).split(splitter)
        ));
        if (get(0).equals("")) {
            remove(0);
        }
    }

    public TextFile(String filename) {
        this(filename, "\n");
    }

    public void write(String filename) {
        try {
            PrintWriter out  = new PrintWriter(
                    new File(filename).getAbsoluteFile()
            );
            try {
                for (String item : this) {
                    out.println(item);
                }
            } finally {
                out.close();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String file = read("./src/main/java/chap18/TextFile.java");
        write("test.txt", file);
        TextFile text = new TextFile("test.txt");
        text.write("text2.txt");
        // Break into unique sorted list of words:
        TreeSet<String> words = new TreeSet<>(
                new TextFile("./src/main/java/chap18/TextFile.java", "\\W+")
        );
        System.out.println(words.headSet("a"));

    }
}
