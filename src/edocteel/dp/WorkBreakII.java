package edocteel.dp;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created by chace on 5/16/14.
 */
public class WorkBreakII {

    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> results = new ArrayList<String>();
        if (s == null || dict.size() <= 0) {
            return results;
        }

        int length = s.length();
        boolean[][] seg = new boolean[length][length+1];
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

        if (!seg[0][length]) {
            return results;
        }

        dfs(s, seg, 0, 0, results, new StringBuilder(), dict);

        return results;
    }

    private void dfs(String s, boolean[][] seg, int start, int depth, ArrayList<String> results, StringBuilder builder, Set<String> dict) {
        if (depth == s.length()) {
            String t = builder.toString();
            results.add(t.substring(0, t.length() - 1));
            return;
        }

        for (int len = 1; len <= s.length(); len++) {
            if (seg[start][len]) {
                String t = s.substring(start, start+len);
                if (dict.contains(t)) {
                    int beforeAddLen = builder.length();
                    builder.append(t);
                    builder.append(" ");
                    dfs(s, seg, start+len, start+len, results, builder, dict);
                    builder.delete(beforeAddLen, builder.length());
                }
            }
        }
    }
}
