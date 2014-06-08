package string;

import java.util.Arrays;

/**
 * Created by chace on 6/7/14.
 */
public class LongestRepeatString {

    public static int comLen(String p, String q) {
        int len = 0;
        int i = 0, j = 0, m = p.length(), n = q.length();
        while (i < m && j < n && p.charAt(i++) == q.charAt(j++)) {
            len++;
        }
        return len;
    }

    // O(n^2)
    public static String lrsBase(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        int maxLen = -1, maxIndex = -1;
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                int len = comLen(str.substring(i), str.substring(j));
                if (len > maxLen) {
                    maxLen = len;
                    maxIndex = i;
                }
            }
        }
        return str.substring(maxIndex, maxIndex + maxLen);
    }

    public static String lrs(String str) {
        String[] suffix = new String[str.length()];
        for (int i = 0; i < str.length(); i++) {
            suffix[i] = str.substring(i);
        }
        Arrays.sort(suffix);
        int maxLen = -1, maxIndex = -1;
        for (int i = 0; i < suffix.length - 1; i++) {
            int len = comLen(suffix[i], suffix[i+1]);
            if (len > maxLen) {
                maxLen = len;
                maxIndex = i;
            }
        }
        return str.substring(maxIndex, maxIndex + maxLen);
    }

    public static void main(String[] args) {
        System.out.println(lrs("AxyxyxA"));
    }
}
