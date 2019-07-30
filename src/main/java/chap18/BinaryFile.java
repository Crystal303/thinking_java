package chap18;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *二进制文件的读取
 * @author crystal303
 */
public class BinaryFile {
    public static byte[] read(File bFile) throws IOException {
        BufferedInputStream br = new BufferedInputStream(
                new FileInputStream(bFile)
        );
        try {
            byte[] data = new byte[br.available()];
            br.read(data);
            return data;
        } finally {
            br.close();
        }
    }

    public static byte[] read(String bFile) throws IOException {
        return read(new File(bFile).getAbsoluteFile());
    }
}
