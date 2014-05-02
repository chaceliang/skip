package edocteel.string;

public class LengthOfLastWord {

	// Iterate from end, how dummy I am.
	public int lengthOfLastWord(String s) {
		if (s == null) {
			return 0;
		}
		int end = s.length() - 1;
		while (end >= 0 && s.charAt(end) == ' ') {
			end--;
		}
		if (end < 0) {
			return 0;
		}
		int start = end;
		while (start - 1 >= 0 && s.charAt(start - 1) != ' ') {
			start--;
		}
		return end - start + 1;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
