package edocteel.dp;

/**
 * Created by chace on 5/14/14.
 */
public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
//        return helper(s, 0, p, 0);
        return helper2(s, p);
    }

    public boolean helper4(String s, int i, String p, int j) {
        if (j == p.length()) {
            return i == s.length();
        }
        if (j == p.length() - 1 || p.charAt(j+1) != '*') {
            if (s.length() == i) {
                return false;
            }
            return (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j)) && helper4(s, i+1, p, j+1);
        }

        while (i < s.length() && (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j))) {
            if (helper4(s, i, p, j+2)) {
                return true;
            }
            i++;
        }
        return helper4(s, i, p, j+2);
    }

    public boolean helper3(String s, int si, String p, int pi) {
        if (pi >= p.length()) {
            return si >= s.length();
        }
        if (pi == p.length() - 1) {
            return (si == s.length() - 1) && (s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '.');
        }

        if (pi + 1 < p.length() && p.charAt(pi+1) != '*') {
            if (si == s.length()) {
                return false;
            }
            if (s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '.') {
                return helper(s, si+1, p, pi+1);
            } else {
                return false;
            }
        }
        while (si < s.length() && pi < p.length() && (s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '.')) {
            if (helper(s, si, p, pi+2)) {
                return true;
            }
            si++;
        }
        return helper(s, si, p, pi+2);
    }

    public boolean helper(String s, int si, String p, int pi) {
        if (pi == p.length()) {
            return si == s.length();
        }
        if (p.charAt(pi) == '*') {
            return false;
        }
        if (si == s.length()) {
            while (pi + 1 < p.length() && p.charAt(pi+1) == '*') {
                pi += 2;
            }
            return pi == p.length();
        }
        if (p.charAt(pi) == '.') {
            if (pi + 1 < p.length() && p.charAt(pi+1) == '*') {
                return helper(s, si+1, p, pi) || helper(s, si+1, p, pi+2) || helper(s, si, p, pi+2);
            } else {
                return helper(s, si+1, p, pi+1);
            }
        } else {
            if (pi + 1 < p.length() && p.charAt(pi+1) == '*') {
                if (s.charAt(si) == p.charAt(pi)) {
                    return helper(s, si+1, p, pi) || helper(s, si+1, p, pi+2) || helper(s, si, p, pi+2);
                } else {
                    return helper(s, si, p, pi+2);
                }
            } else {
                return s.charAt(si) == p.charAt(pi) && helper(s, si+1, p, pi+1);
            }
        }
    }

    public boolean helper2(String s, String p) {
        if (p.length() == 0) {
            return s.length() == 0;
        }
        if (p.startsWith("*")) {
            return false;
        }
        if (s.length() == 0) {
            while (p.length() >= 2 && p.charAt(1) == '*') {
                p = p.substring(2);
            }
            return p.length() == 0;
        }
        if (p.startsWith(".")) {
            if (p.length() >= 2 && p.charAt(1) == '*') {
                return helper2(s.substring(1), p) || helper2(s.substring(1), p.substring(2)) || helper2(s, p.substring(2));
            } else {
                return helper2(s.substring(1), p.substring(1));
            }
        } else {
            if (p.length() >= 2 && p.charAt(1) == '*') {
                if (s.charAt(0) == p.charAt(0)) {
                    return helper2(s.substring(1), p) || helper2(s.substring(1), p.substring(2)) || helper2(s, p.substring(2));
                }
                return helper2(s, p.substring(2));
            } else {
                return s.charAt(0) == p.charAt(0) && helper2(s.substring(1), p.substring(1));
            }
        }
    }

    public static void main(String[] args) {
        RegularExpressionMatching test = new RegularExpressionMatching();
        System.out.println(test.isMatch("ba", ".*a*a"));
    }
}
