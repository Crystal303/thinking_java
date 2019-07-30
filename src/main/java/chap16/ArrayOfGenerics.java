package chap16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 容器泛型检查仅限于当前引用
 * 获得List<String>[]的引用 获得了编译期的检查
 * @author crystal303
 */
public class ArrayOfGenerics {
    public static void main(String[] args) {
        List<String>[] ls;
        List[] la = new List[10];
        ls = la;
        ls[0] = new ArrayList<>();
        //! ls[1] = new ArrayList<Integer>();
        la[1] = new ArrayList();
        la[1].add(13);

        ls[1].add("衣垣");
        //! ls[1].add(12);
        la[1].add(12);
        System.out.println(Arrays.deepToString(la));
        System.out.println(Arrays.deepToString(ls));
    }
}
