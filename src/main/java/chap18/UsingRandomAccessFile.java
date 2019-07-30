package chap18;

import java.io.IOException;
import java.io.RandomAccessFile;

public class UsingRandomAccessFile {
    static String file = "./src/main/resources/rtest.dat";
    static void display() throws IOException {
        RandomAccessFile rf = new RandomAccessFile(file, "r");
        for (int i = 0; i < 7; i++) {
            System.out.println(
                    "Value" + i + ": " + rf.readInt()
            );
        }
        System.out.println(rf.readUTF());
        rf.close();
    }

    public static void main(String[] args) throws IOException {
        RandomAccessFile rf = new RandomAccessFile(file, "rw");
        for (int i = 0; i < 7; i++) {
            rf.writeInt(i * 414);
        }
        rf.writeUTF("The end");
        rf.close();
        display();

        rf = new RandomAccessFile(file, "rw");
        rf.seek(5*4);
        rf.writeInt(47);
        rf.close();
        display();
    }
}
