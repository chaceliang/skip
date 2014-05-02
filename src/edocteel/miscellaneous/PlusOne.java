package edocteel.miscellaneous;

public class PlusOne {

	public int[] plusOne(int[] digits) {
		if (digits == null || digits.length <= 0) {
			return new int[] {1};
		}
		int carry = 1;
		int bit = 0;
		boolean needNewArray = true;
		for (int i = digits.length - 1; i >= 0; i--) {
			bit = (digits[i] + carry) % 10;
			carry = (digits[i] + carry) / 10;
			if (carry == 0) {
				needNewArray = false;
				break;
			}
		}
		if (!needNewArray) {
			return digits;
		}
		int[] newDigits = new int[digits.length + 1];
		newDigits[0] = carry;
		for (int i = 1; i < newDigits.length; i++) {
			newDigits[i] = digits[i-1];
		}
		return newDigits;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
