package edocteel.string;

public class LongestPalidromicSubstring {

	public String longestPalindrome(String s) {
		if (s == null || s.length() <= 0) {
			return "";
		}
		String longestPalindrome = s.substring(0, 1);
		for (int i = 1; i < s.length(); i++) {
			String p1 = expandAround(s, i, i);
			if (p1.length() > longestPalindrome.length()) {
				longestPalindrome = p1;
			}
			String p2 = expandAround(s, i-1, i);
			if (p2.length() > longestPalindrome.length()) {
				longestPalindrome = p2;
			}
		}
		return longestPalindrome;
    }
	
	public String expandAround(String s, int l, int r) {
		while (l >= 0 && r < s.length()) {
			if (s.charAt(l) != s.charAt(r)) {
				break;
			}
			l--; 
			r++;
		}
		return s.substring(l+1, r);
	}
	
	public String longestPalindromeDP(String s) {
		if (s == null || s.length() <= 0) {
			return "";
		}
		int length = s.length();
		int longestStart = 0;
		int maxLen = 1;
		boolean[][] table = new boolean[length][length];
		for (int i = 0; i < length; i++) {
			table[i][i] = true;
		}
		for (int i = 0; i < length - 1; i++) {
			if (s.charAt(i) == s.charAt(i+1)) {
				table[i][i+1] = true;
				longestStart = i;
				maxLen = 2;
			} else {
				table[i][i+1] = false;
			}
		}
		for(int len = 3; len <= length; len++) {
			for (int i = 0; i < length - len + 1; i++) {
				int j = i + len - 1;
				if (s.charAt(i) == s.charAt(j) && table[i+1][j-1]) {
					table[i][j] = true;
					longestStart = i;
					maxLen = len;
				}
			}
		}
		return s.substring(longestStart, longestStart + maxLen);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LongestPalidromicSubstring test = new LongestPalidromicSubstring();
		test.longestPalindrome("bb");
	}

}
