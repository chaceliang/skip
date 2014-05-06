package edocteel.dp;

import java.util.ArrayList;

/**
 * Created by chace on 5/5/14.
 */
public class DecodeWays {

    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        for (int i = 1; i < s.length(); i++) {
            if ((s.charAt(i-1) > '2' || s.charAt(i-1) == '0') && s.charAt(i) == '0') {
                return 0;
            }
        }

        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < s.length() + 1; i++) {
            if (s.charAt(i-1) == '0') {
                dp[i] = dp[i-2];
            } else if (s.charAt(i-2) == '1' || (s.charAt(i-2) == '2' && s.charAt(i-1) <= '6')) {
                dp[i] = dp[i-2] + dp[i-1];
            } else {
                dp[i] = dp[i-1];
            }
        }
        return dp[s.length()];
    }

    public int numDecodings1(String s) {
        if (s == null || s.length() <= 0) {
            return 0;
        }
        ArrayList<Integer> results = new ArrayList<Integer>();
        helper(s, results);
        return results.size();
    }

    public void helper(String s, ArrayList<Integer> results) {
        if (s.length() == 0) {
            results.add(1);
        } else {
            int value = s.charAt(0) - '0';
            if (value >= 0 && value <= 9) {
                helper(s.substring(1), results);
            }
            if (s.length() >= 2) {
                int v1 = s.charAt(0) - '0';
                int v2 = s.charAt(1) - '0';
                if (v1 == 1 && v2 >= 0 && v2 <= 9) {
                    helper(s.substring(2), results);
                } else if (v1 == 2 && v2 >= 0 && v2 <= 6) {
                    helper(s.substring(2), results);
                }
            }
        }
    }
}
