package chap18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class MemoryInput {
    public static void main(String[] args) throws IOException {
        StringReader in = new StringReader(
                BufferedInputFile.read("/home/crystal303/IdeaProjects/thinking_java/src/main/java/chap18/BufferedInputFile.java")
        );
        int c;
        while ((c = in.read()) != -1) {
            System.out.print((char)c);
        }
    }
}
