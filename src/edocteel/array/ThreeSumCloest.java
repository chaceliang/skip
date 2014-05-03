package edocteel.array;

import java.util.Arrays;

public class ThreeSumCloest {

	public static int threeSumClosest(int[] num, int target) {
		if (num == null || num.length <= 0) {
			return -1;
		}
		Arrays.sort(num);
		int len = num.length;
		int cloest = Integer.MAX_VALUE;
		int cloestSum = 0;
		for (int i = 0; i < len - 2; i++) {
			int start = i + 1;
			int end = len - 1;
			while (start < end) {
				int runningSum = num[i] + num[start] + num[end];
				int runningCloest = Math.abs(runningSum - target);
				if (runningCloest < cloest) {
					cloest = runningCloest;
					cloestSum = runningSum;
				}
				if (runningSum > target) {
					end--;
				} else if (runningSum < target) {
					start++;
				} else {
					return target;
				}
			}
		}
		return cloestSum;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		threeSumClosest(new int[]{0,0,0}, 1);
	}

}
