package pointTo;

import java.util.Arrays;

public class Question44IsContinous {

	public static boolean isContinous(int[] input) {
		if (input == null || input.length < 0) {
			return false;
		}
		Arrays.sort(input);
		int numberOfZeroes = 0;
		int numberOfGaps = 0;
		for (int i = 0; i < input.length; i++) {
			if (input[i] == 0) {
				numberOfZeroes++;
			}
		}
		int small = numberOfZeroes;
		int big = small + 1;
		
		while (big < input.length) {
			if (input[big] == input[small]) {
				return false;
			}
			numberOfGaps += input[big] - input[small] - 1;
			small = big;
			big++;
		}
		return numberOfGaps > numberOfZeroes ? false : true;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
