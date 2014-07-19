package pointTo;

public class Question24VerifyBSTSequence {

	public static boolean isBSTSequence(int[] input, int start, int end) {
		if (input == null) {
			return false;
		}
		
		int root = input[end-1];
		int i = 0;
		for (; i < end-1; i++) {
			if (input[i] > root) {
				break;
			}
		}
		int j = i;
		for (; j < end-1; j++) {
			if (input[j] < root) {
				return false;
			}
		}
		boolean left = true;
		if (i > 0) {
			left = isBSTSequence(input, 0, i);
		}
		boolean right = true;
		if (i < end - 1) {
			right = isBSTSequence(input, i+1, end - 1);
		}
		return left && right;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
