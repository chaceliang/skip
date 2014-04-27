package pointTo;

public class Question32NumberOf1 {
	
	public static int powerBase10(int n) {
		int result = 1;
		for (int i = 0; i < n; i++) {
			result *= 10;
		}
		return result;
	}
	
	public static int numberOf1(String num) {
		if (num == null || num.isEmpty() || num.charAt(0) < '0' || num.charAt(0) > '9') {
			return 0;
		}
		
		int first = num.charAt(0) - 48;
		if (num.length() == 1 && first == 0) {
			return 0;
		}
		if (num.length() == 1 && first > 0) {
			return 1;
		}
		
		int numFirstDigit = 0;
		if (first > 1) {
			numFirstDigit = powerBase10(num.length() - 1);
		} else {
			numFirstDigit = Integer.parseInt(num.substring(1)) + 1;
		}
		
		int numOtherDigit = first * (num.length() - 1) * powerBase10(num.length() - 2);
		int numRecursion = numberOf1(num.substring(1));
		return numFirstDigit + numOtherDigit + numRecursion;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
