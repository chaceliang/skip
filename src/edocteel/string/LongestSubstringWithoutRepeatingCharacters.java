package edocteel.string;

import java.util.HashMap;
import java.util.Hashtable;

public class LongestSubstringWithoutRepeatingCharacters {

	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() <= 0) {
			return 0;
		}
		int i = 0, j = 0;
		int result = 0;
		Hashtable<Character, Integer> map = new Hashtable<Character, Integer>();
		while (j < s.length()) {
			Character c = s.charAt(j);
			if (map.containsKey(c)) {
				int length = j - i;
				if (result < length) {
					result = length;
				}
				Integer index = map.get(c);
				i = Math.max(i, index+1);
			}
			map.put(c, j);
			j++;
		}
		if (result < j - i) {
			return j - i;
		} 
		return result;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
