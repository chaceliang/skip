package pointTo;

import java.util.HashMap;

public class Question41TwoSum {
	
	public static void twoSumInOrder(int[] input, int target) {
		if  (input == null || input.length < 2) {
			return;
		}
		int start = 0, end = input.length - 1;
		while (start < end) {
			int tempSum = input[start] + input[end];
			if (tempSum > target) {
				end--;
			} else if (tempSum < target) {
				start++;
			} else {
				System.out.println(input[start] + " " + input[end]);
				break;
			}
		}
	}
	
	public static void twoSumDisorder(int[] input, int target) {
		if  (input == null || input.length < 2) {
			return;
		}
		
		HashMap<Integer, Integer> want_orig = new HashMap<Integer, Integer>();
		for (int i = 0; i < input.length; i++) {
			int want = target - input[i];
			want_orig.put(want, input[i]);
		}
		for (int i = 0; i < input.length; i++) {
			if (want_orig.get(input[i]) != null) {
				System.out.println(input[i] + " " + want_orig.get(input[i]));
				break;
			}
		}
	}
	
	public static void findContinuousSequence(int sum) {
		if (sum < 3) {
			return;
		}
		int small = 1;
		int big = 2;
		int middle = (1 + sum) / 2;
		int currentSum = small + big;
		while (small < middle) {
			if (currentSum == sum) {
				print(small, big);
			}
			
			while (currentSum > sum && small < middle) {
				currentSum -= small;
				small++;
				if (currentSum == sum) {
					print(small, big);
				}
			}
			
			big++;
			currentSum += big;
		}
	}
	
	public static void print(int start, int end) {
		for (int i = start; i <= end; i++) {
			System.out.print(i + " ");
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] test1 = {1,2,4,7,11,15};
//		twoSumInOrder(test1, 15);
		twoSumDisorder(test1, 15);
	}

}
