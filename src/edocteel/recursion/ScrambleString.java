package edocteel.recursion;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * Created by chace on 5/14/14.
 */
public class ScrambleString {
    public static HashMap<String, Boolean> ht = new HashMap<String, Boolean>();
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }

        String key = s1 + s2;
        if (s1.compareTo(s2) > 0) {
            key = s2 + s1;
        }
        if (ht.containsKey(key)) {
            return ht.get(key);
        }

        for (int i = 1; i < s1.length(); i++) {
            String s11 = s1.substring(0, i);
            String s12 = s1.substring(i);

            String s21 = s2.substring(0, i);
            String s22 = s2.substring(i);

            if (isScramble(s11, s21) && isScramble(s12, s22)) {
                ht.put(key, true);
                return true;
            }

            s21 = s2.substring(s2.length() - i);
            s22 = s2.substring(0, s2.length() - i);

            if (isScramble(s11, s21) && isScramble(s12, s22)) {
                ht.put(key, true);
                return true;
            }
        }
        ht.put(key, false);
        return false;
    }
}
