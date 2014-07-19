package pointTo;

public class Question09Fibonacci {
	
	public static long fibonacci(int n) {
		int result[] = {0, 1};
		if (n < 2) {
			return result[n];
		}
		long fib1 = 0;
		long fib2 = 1;
		long fibN = 0;
		for (int i = 2; i <= n; i++) {
			fibN = fib1 + fib2;
			fib1 = fib2;
			fib2 = fibN;
		}
		return fibN;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(fibonacci(3));
	}

}
