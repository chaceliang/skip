package edocteel.dp;

import java.util.HashMap;

/**
 * Created by chace on 5/12/14.
 */
public class MinimumWindowSubstring {
    public static String minWindow(String S, String T) {
        if (S == null || T == null) {
            return "";
        }
        int lenS = S.length(), lenT = T.length();
        int[] appearCount = new int[256];
        int[] expectedCount = new int[256];
        for (int i = 0; i < T.length(); i++) {
            expectedCount[T.charAt(i)]++;
        }

        int minLen = Integer.MAX_VALUE, minStart = 0;
        int wildStart = 0;
        int appeared = 0;
        for (int wildEnd = 0; wildEnd < lenS; wildEnd++) {
            appearCount[S.charAt(wildEnd)]++;
            if (expectedCount[S.charAt(wildEnd)] > 0) {
                if (appearCount[S.charAt(wildEnd)] <= expectedCount[S.charAt(wildEnd)]) {
                    appeared++;
                }
            }
            if (appeared == lenT) {
                while (appearCount[S.charAt(wildStart)] > expectedCount[S.charAt(wildStart)] || expectedCount[S.charAt(wildStart)] == 0) {
                    appearCount[S.charAt(wildStart)]--;
                    wildStart++;
                }
                if (minLen > wildEnd - wildStart + 1) {
                    minLen = wildEnd - wildStart + 1;
                    minStart = wildStart;
                }
            }
        }
        if (minLen == Integer.MAX_VALUE) {
            return "";
        }
        return S.substring(minStart, minStart + minLen);
    }

    public static String minWindow2(String S, String T)  {
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
        System.out.println(minWindow("AXAXBA", "AB"));
    }
}
