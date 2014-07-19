package pointTo;

public class Question47AddWithoutOperation {

	public static int add(int a, int b) {
		int sum = 0, carry = 0;
		do {
			sum = a ^ b;
			carry = (a & b) << 1;
			a = sum;
			b = carry;
		} while (b != 0);
		return a;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a = 5, b = 7;
		System.out.println(add(a, b));
	}

}
