package edocteel.string;

public class LongestCommonPrefix {

	public String longestCommonPrefixSlow(String[] strs) {
		if (strs == null || strs.length <= 0) {
			return "";
		}
		int index = 0;
		while (index < strs[0].length()) {
			char c = strs[0].charAt(index);
			for (int i = 1; i < strs.length; i++) {
				if (index >= strs[i].length() || strs[i].charAt(index) != c) {
					return strs[0].substring(0, index);
				}
			}
			index++;
		}
		return "";
	}
	
	public String longestCommonPrefixFast(String[] strs) {
		if (strs == null || strs.length <= 0) {
			return "";
		}
		return binarySearch(0, strs.length - 1, strs);
	}
	
	public String commonPrefix(String a, String b) {
		if (a == null || a.length() <= 0 || b == null || b.length() <= 0) {
			return "";
		}
		int length = Math.min(a.length(), b.length());
		int i = 0;
		for (; i < length; i++) {
			if (a.charAt(i) != b.charAt(i)) {
				break;
			}
		}
		return a.substring(0, i);
	}
	
	public String binarySearch(int s, int e, String[] strs) {
		if (s > e) {
			return null;
		}
		if (s == e) {
			return strs[s];
		}
		return commonPrefix(binarySearch(s, (s+e)/2, strs), binarySearch((s+e)/2+1, e, strs));
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
