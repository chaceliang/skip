package string;

import java.util.Hashtable;

/**
 * Created by chace on 6/22/14.
 */
public class Isomorphic {

    public static boolean isIsomorphic(String str1, String str2) {
        if (str1 == null || str2 == null) {
            throw new NullPointerException();
        }
        if (str1.length() != str2.length()) {
            return false;
        }

        int len = str1.length();
        Hashtable<Character, Character> map1 = new Hashtable<Character, Character>();
        Hashtable<Character, Character> map2 = new Hashtable<Character, Character>();
        for (int i = 0; i < len; i++) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);
            if (!map1.containsKey(c1) && !map2.containsKey(c2)) {
                map1.put(c1, c2);
                map2.put(c2, c1);
            } else if (map1.containsKey(c1) && map2.containsKey(c2)) {
                if (!map1.get(c1).equals(c2) || !map2.get(c2).equals(c1)){
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(Isomorphic.isIsomorphic("foo", "bar"));
        System.out.println(Isomorphic.isIsomorphic("bar", "foo"));
        System.out.println(Isomorphic.isIsomorphic("turtle", "tletur"));
        System.out.println(Isomorphic.isIsomorphic("tletur", "turtle"));
        System.out.println(Isomorphic.isIsomorphic("foo", "baa"));
    }
}
