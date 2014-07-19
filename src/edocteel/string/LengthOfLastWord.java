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
		int start = end;
		while (start >= 0 && s.charAt(start) != ' ') {
			start--;
		}
		return end - start;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
