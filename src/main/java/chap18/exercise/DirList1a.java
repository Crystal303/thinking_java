package chap18.exercise;


import java.util.regex.*;
import java.io.*;
import java.util.*;

public class DirList1a {
    public static void main(final String[] args) {
        File path = new File("/home/crystal303/IdeaProjects/thinking_java/src/main/java/chap21");
        final String[] list;
        if(args.length < 2) {
            list = path.list();
            System.out.println("Usage: enter filtering regex");
            System.out.println(
                    "followed by words, one or more of which each file must contain.");
        }
        else {
            list = path.list(new FilenameFilter() {
                private Pattern pattern = Pattern.compile(args[0]);
                @Override
                public boolean accept(File dir, String name) {
                    return pattern.matcher(name).matches();
                }
            });
        }
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for(String dirItem : list) {
            System.out.println(dirItem);
        }
    }
}

