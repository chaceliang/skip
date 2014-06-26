package edocteel.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class FourSum {

    /*
    Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

    Note:
    Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
    The solution set must not contain duplicate quadruplets.
        For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

        A solution set is:
        (-1,  0, 0, 1)
        (-2, -1, 1, 2)
        (-2,  0, 0, 2)
     */
	public static ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {

		Arrays.sort(num);
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		if (num.length < 4)
			return results;
		HashSet set = new HashSet();
		for (int i = 0; i < num.length - 3; i++) {
			for (int j = i + 1; j < num.length - 2; j++) {
				int start = j + 1;
				int end = num.length - 1;
				int left = target - num[i] - num[j];
				while (start < end) {
					int s = num[start] + num[end];
					if (s > left) {
						end--;
					} else if (s < left) {
						start++;
					} else {
						ArrayList<Integer> result = new ArrayList<Integer>();
						result.add(num[i]);
						result.add(num[j]);
						result.add(num[start]);
						result.add(num[end]);
						set.add(result);
						start++; end--;
					}
				}
			}
		}
		Iterator it = set.iterator();
		while (it.hasNext()) {
			results.add((ArrayList<Integer>) it.next());
		}
		return results;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
