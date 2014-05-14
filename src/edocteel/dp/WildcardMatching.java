package edocteel.dp;

/**
 * Created by chace on 5/14/14.
 */
public class WildcardMatching {

    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        int star = -1;
        int si = 0, pi = 0;
        int lens = s.length(), lenp = p.length();
        int sp = 0;

        while (si < lens) {
            while (pi < lenp && p.charAt(pi) == '*') {
                star = pi++;
                sp = si;
            }
            if (pi == lenp || (p.charAt(pi) != s.charAt(si) && p.charAt(pi) != '?')) {
                if (star < 0) {
                    return false;
                } else {
                    pi = star + 1;
                    si = ++sp;
                }
            } else {
                si++;
                pi++;
            }
        }
        while (pi < lenp && p.charAt(pi) == '*') {
            pi++;
        }
        return pi == lenp;
    }

    public boolean isMatchDP(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        int lenS = s.length(), lenP = p.length();
        if (lenS <= 0) {
            int i = 0;
            while (i < lenP && p.charAt(i) == '*') {
                i++;
            }
            return i == lenP;
        }
        if (lenP <= 0) {
            return false;
        }

        boolean[][] dp = new boolean[lenS+1][lenP+1];
        dp[0][0] = true;
        for (int i = 1; i <= lenS; i++) {
            for (int j = 1; j <= lenP; j++) {
                if (dp[i-1][j-1] && (s.charAt(i-1) == p.charAt(j-1) || '?' == p.charAt(j-1))) {
                    dp[i][j] = true;
                }
                if ('*' == p.charAt(j-1)) {
                    if (dp[i-1][j-1]) {
                        for (int k = i-1; k <= lenS; k++) {
                            dp[k][j] = true;
                        }
                        break;
                    }
                    if (dp[i][j-1]) {
                        for (int k = i; k <= lenS; k++) {
                            dp[k][j] = true;
                        }
                        break;
                    }
                }
            }
        }
        return dp[lenS][lenP];
    }

    public boolean isMatchRecursive(String s, String p) {
        return helper(s, 0, p, 0);
    }

    public boolean helper(String s, int si, String p, int pi) {
        if (pi == p.length()) {
            return si == s.length();
        }
        if (si == s.length()) {
            while (pi < p.length() && p.charAt(pi) == '*') {
                pi++;
            }
            return pi == p.length();
        }

        if (p.charAt(pi) == '?') {
            return  helper(s, si+1, p, pi+1);
        } else if (p.charAt(pi) == '*') {
            return helper(s, si+1, p, pi) || helper(s, si+1, p, pi+1) || helper(s, si, p, pi+1);
        } else {
            return s.charAt(si) == p.charAt(pi) && helper(s, si+1, p, pi+1);
        }
    }

}
