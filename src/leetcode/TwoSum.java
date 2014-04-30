package leetcode;

import java.util.HashMap;

public class TwoSum {

	public int[] twoSum(int[] numbers, int target) {
		if (numbers.length == 0) {
			return null;
		}
		HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
		int[] result = new int[2];
		int small = 0;
		int big = 0;
		for (int i = 0; i < numbers.length; i++) {
			if (!hash.containsKey(numbers[i])) {
				hash.put(target - numbers[i], i);
			} else {
				small = hash.get(numbers[i]);
				big = i;
			}
		}
		result[0] = small + 1;
		result[1] = big + 1;
		return result;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
