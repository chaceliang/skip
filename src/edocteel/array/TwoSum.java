package edocteel.array;

import java.util.HashMap;

public class TwoSum {

    /*
    Given an array of integers, find two numbers such that they add up to a specific target number.

    The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

    You may assume that each input would have exactly one solution.

    Input: numbers={2, 7, 11, 15}, target=9
    Output: index1=1, index2=2
     */
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
