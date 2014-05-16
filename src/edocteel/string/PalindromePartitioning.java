package edocteel.string;

import java.util.ArrayList;

/**
 * Created by chace on 5/16/14.
 */
public class PalindromePartitioning {

    public boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }

    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
        ArrayList<String> result = new ArrayList<String>();

        palinPartition(s, 0, s.length(), result, results);

        return results;
    }

    public void palinPartition(String s, int start, int len, ArrayList<String> result, ArrayList<ArrayList<String>> results) {
        if (start == len) {
            ArrayList<String> tmp = new ArrayList<String>();
            tmp.addAll(result);
            results.add(tmp);
            return;
        }

        for (int i = start; i < len; i++) {
            if (isPalindrome(s, start, i)) {
                result.add(s.substring(start, i+1));
                palinPartition(s, i+1, len, result, results);
                result.remove(result.size() - 1);
            }
        }
    }
}
