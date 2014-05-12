package edocteel.dp;

/**
 * Created by chace on 5/12/14.
 */
public class MinimumWindowSubstring {
    public String minWindow(String S, String T) {
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
            if (expectedCount[S.charAt(wildEnd)] > 0) {
                appearCount[S.charAt(wildEnd)]++;
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

    public static void main(String[] args) {
    }
}
