package edocteel.dp;

import java.util.Set;

/**
 * Created by chace on 5/16/14.
 */
public class WordBreak {

    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || dict.size() <= 0) {
            return false;
        }
        int length = s.length();
        boolean[][] seg = new boolean[length][length + 1];
        for (int len = 1; len <= length; len++) {
            for (int i = 0; i <= length - len; i++) {
                String str = s.substring(i, i+len);
                if (dict.contains(str)) {
                    seg[i][len] = true;
                    continue;
                }
                for (int k = 1; k < len; k++) {
                    if (seg[i][k] && seg[i+k][len-k]) {
                        seg[i][len] = true;
                        break;
                    }
                }
            }
        }
        return seg[0][length];
    }
}
