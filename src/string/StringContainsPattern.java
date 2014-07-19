package string;

import java.util.HashMap;

/**
 * Created by chace on 5/28/14.
 */
public class StringContainsPattern {

    public static String minWindow(String S, String T)  {
        HashMap<Character, Integer> pattern = new HashMap<Character, Integer>();
        for (int i = 0; i < T.length(); i++) {
            Character t = T.charAt(i);
            if (pattern.containsKey(t)) {
                pattern.put(t, pattern.get(t) + 1);
            } else {
                pattern.put(t, 1);
            }
        }
        int count = 0, prev = 0;
        int minLen = S.length() + 1;
        String res = "";
        for (int i = 0; i < S.length(); i++) {
            Character t = S.charAt(i);
            if (pattern.containsKey(t)) {
                pattern.put(t, pattern.get(t) - 1);
                if (pattern.get(t) >= 0) {
                    count++;
                }
                while (count == T.length()) {
                    if (pattern.containsKey(S.charAt(prev))) {
                        pattern.put(S.charAt(prev), pattern.get(S.charAt(prev)) + 1);
                        if (pattern.get(S.charAt(prev)) > 0) {
                            if (minLen > i - prev +1) {
                                minLen = i - prev + 1;
                                res = S.substring(prev, i+1);
                            }
                            count--;
                        }
                    }
                    prev++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(minWindow("AXAXBAB", "AB"));
    }
}
