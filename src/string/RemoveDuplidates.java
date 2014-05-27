package string;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by chace on 5/26/14.
 */
public class RemoveDuplidates {
    public static String removeDuplicates(String s) {
        if (s == null || s.length() <= 0) {
            return s;
        }
        HashSet<Character> existing = new HashSet<Character>();
        StringBuilder builder = new StringBuilder();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char t = s.charAt(i);
            if (!existing.contains(t)) {
                existing.add(t);
                builder.append(t);
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates("aaaaab"));
        System.out.println(removeDuplicates("abcdefabcd"));
    }
}
