package edocteel.string;

import java.util.ArrayList;

/**
 * Created by chace on 5/16/14.
 */
public class PalindromePartitioning {

    /*Given a string s, partition s such that every substring of the partition is a palindrome.

    Return all possible palindrome partitioning of s.

    For example, given s = "aab",
    Return

      [
        ["aa","b"],
        ["a","a","b"]
      ]
  */
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

        palinPartition(s, 0, result, results);

        return results;
    }

    public void palinPartition(String s, int start, ArrayList<String> result, ArrayList<ArrayList<String>> results) {
        if (start == s.length()) {
            ArrayList<String> tmp = new ArrayList<String>();
            tmp.addAll(result);
            results.add(tmp);
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                result.add(s.substring(start, i+1));
                palinPartition(s, i+1, result, results);
                result.remove(result.size() - 1);
            }
        }
    }
}
