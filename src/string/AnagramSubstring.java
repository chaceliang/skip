package string;

import java.util.ArrayList;

/**
 * Created by chace on 6/9/14.
 */
public class AnagramSubstring {

    public static ArrayList<String> findAnagram(String s, String t) {
        if (s == null || t == null) {
            throw new NullPointerException();
        }
        ArrayList<String> results = new ArrayList<String>();
        if (s.length() < t.length()) {
            return results;
        }
        int lens = s.length();
        int lent = t.length();
        int[] exists = new int[26];
        int[] current = new int[26];
        for (int i = 0; i < t.length(); i++) {
            exists[t.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            current[s.charAt(i) - 'a']++;
        }
        if (isSameArray(exists, current)) {
            results.add(s.substring(0, 0+t.length()));
        }
        char prev = s.charAt(0);
        for (int i = 1; i <= lens - lent; i++) {
            current[prev - 'a']--;
            current[s.charAt(i + lent - 1) - 'a']++;
            if (isSameArray(exists, current)) {
                results.add(s.substring(i, i + t.length()));
            }
            prev = s.charAt(i);
        }
        return results;
    }

    public static boolean isSameArray(int[] a, int[] b) {
        if (a == null || b == null || a.length != b.length) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ArrayList<String> results = findAnagram("abacab", "abc");
        for (String i : results) {
            System.out.println(i);
        }
    }
}
