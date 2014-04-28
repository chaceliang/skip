package pointTo;

public class Question48StringAndInt {
	
	public static int atoi(String input) {
		if (input == null || input.length() < 0) {
			return 0;
		}
		
		final char PLUS = '+';
		final char MINUS = '-';
		final char SPACE = ' ';
		
		int result = 0;
		boolean hasNegativeSign = false;
		
		if (input.charAt(0) == PLUS || input.charAt(0) == MINUS) {
			if (input.charAt(0) == MINUS) {
				hasNegativeSign = true;
			}
			input = input.substring(1);
		}
		
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c == SPACE || c > '9' || c < '0') {
				continue;
			} else {
				result = result * 10 + (c - '0');
			}
		}
		if (hasNegativeSign) {
			result *= -1;
		}
		return result;
	}

	public static String itoa(int input) {
		if (input == 0) {
			return "0";
		}
		StringBuilder builder = new StringBuilder();
		boolean hasNegativeSign = false;
		if (input < 0) {
			hasNegativeSign = true;
			input *= -1;
		}
		int low = 0;
		while (input > 0) {
			low = input % 10;
			input /= 10;
			builder.append(low);
		}
		if (hasNegativeSign) {
			builder.append("-");
		}
		return builder.reverse().toString();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(atoi("+123"));
		System.out.println(atoi("-123"));
		System.out.println(atoi(" 1 2  3 "));
		System.out.println(atoi(null));
		System.out.println(atoi("0"));
		
		System.out.println("----------------");
		System.out.println(itoa(123));
		System.out.println(itoa(-123));
		System.out.println(itoa(0));
	}

}
