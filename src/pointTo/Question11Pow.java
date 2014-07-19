package pointTo;

public class Question11Pow {

	public static double pow(double base, int exponent) {
		if (exponent == 0) {
			return 1;
		}
		if (exponent == 1) {
			return base;
		}
		
		double result = pow(base, exponent / 2);
		result *= result;
		if (exponent % 2 == 1) {
			result *= base;
		}
		return result;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(pow(5, 2));
		System.out.println(pow(10, -2));
		System.out.println(pow(-5, 2));
	}

}
