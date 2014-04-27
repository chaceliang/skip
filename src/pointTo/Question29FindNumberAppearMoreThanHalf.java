package pointTo;

public class Question29FindNumberAppearMoreThanHalf {

	public static int findNumberApearMoreThanHalf(int[] input) {
		if (input == null || input.length <= 0) {
			return -1;
		}
		int result = input[0];
		int times = 1;
		for (int i = 1; i < input.length; i++) {
			if (times == 0) {
				result = input[i];
				times = 1;
			} else if (input[i] == result) {
				times++;
			} else {
				times--;
			}
		}
		if (!checkForHalf(input, result)) {
			return -1;
		}
		return result;
	}
	
	public static boolean checkForHalf(int[] input, int number) {
		int times = 0;
		for (int i = 0; i < input.length; i++) {
			if (input[i] == number) {
				times++;
			}
		}
		return times > input.length / 2;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] input = {1,2,3,2,2,2,5,3,2};
		System.out.println(findNumberApearMoreThanHalf(input));

	}

}
