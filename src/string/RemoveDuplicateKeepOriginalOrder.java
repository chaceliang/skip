package string;

import java.util.Hashtable;

/**
 * Created by chace on 6/8/14.
 */
public class RemoveDuplicateKeepOriginalOrder {
    public static String removeDuplicate(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        StringBuilder builder = new StringBuilder();
        Hashtable<Character, Integer> map = new Hashtable<Character, Integer>();

        for (int i = 0; i < str.length(); i++) {
            char t = str.charAt(i);
            if (!map.containsKey(t)) {
                builder.append(t);
                map.put(t, 1);
            }
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicate("abcdace"));
        System.out.println(removeDuplicate("aaaaaae"));
    }
}
