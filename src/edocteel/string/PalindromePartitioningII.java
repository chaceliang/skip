package edocteel.string;

/**
 * Created by chace on 5/16/14.
 */
public class PalindromePartitioningII {
    public int minCut(String s) {
        if (s == null || s.length() <= 0) {
            return 0;
        }
        int len = s.length();
        int[] cuts = new int[len];
        for (int i = len-1; i >= 0; i--) {
            String str = s.substring(i);
            if (isPalindrome(str)) {
                cuts[i] = 0;
            } else {
                cuts[i] = getMin(s, i, len, cuts);
            }
        }
        return cuts[0];
    }

    public int getMin(String s, int i, int len, int[] cuts) {
        int min = Integer.MAX_VALUE;
        for (int j = i+1; j < len; j++) {
            if (cuts[j] < min && isPalindrome(s.substring(i, j))) {
                min = cuts[j];
            }
        }
        return min+1;
    }

    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
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

    public static void main(String[] args) {
        PalindromePartitioningII test = new PalindromePartitioningII();
        test.minCut("ab");
    }
}
