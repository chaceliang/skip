package pointTo;

public class Question31MaxSequenceSubArray {

	public static void findMaxSequenceSubArray(int[] input) {
		if (input == null || input.length <= 0) {
			return;
		}
		int currentSum = 0;
		int greatestSum = Integer.MIN_VALUE;
		int start = 0; int end = 0;
		for (int i = 0; i < input.length; i++) {
			if (currentSum < 0) {
				currentSum = input[i];
				start = i;
			} else {
				currentSum += input[i];
			}
			if (currentSum > greatestSum) {
				greatestSum = currentSum;
				end = i;
			}
		}
		for (int i = start; i <= end; i++) {
			System.out.print(input[i] + " ");
		}
		System.out.println();
		System.out.println(greatestSum);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] input = {1,-2,3,10,-4,7,2,-5};
		findMaxSequenceSubArray(input);
	}

}
