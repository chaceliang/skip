package edocteel.string;

public class AddBinary {

	public String addBinary(String a, String b) {
		StringBuilder builder = new StringBuilder();
		int ai = a.length() - 1, bi = b.length() - 1;
		int carry = 0;
		int bit = 0;
		while (ai >= 0 || bi >= 0) {
			int A = 0, B = 0;
			if (ai >= 0 && bi >= 0) {
				A = a.charAt(ai--) - '0';
				B = b.charAt(bi--) - '0';
			} else if (ai >= 0) {
				A = a.charAt(ai--) - '0';
				B = 0;
			} else {
				A = 0;
				B = b.charAt(bi--) - '0';
			}
			bit = (A + B + carry) % 2;
			carry = (A + B + carry) / 2;
			builder.insert(0, bit);
		}
		if (carry > 0) {
			builder.insert(0, carry);
		}
		return builder.toString();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}

}
