package edocteel.recursion;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by chace on 5/4/14.
 */
public class CombinationSumII {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        Arrays.sort(num);
        solve(results, result, num, 0, target);
        return results;
    }

    public void solve(ArrayList<ArrayList<Integer>> results, ArrayList<Integer> result, int[] num, int start, int target) {
        if (target == 0) {
            results.add((ArrayList<Integer>)result.clone());
        } else if (start == num.length) {
            return;
        } else {
            for (int i = start; i < num.length && num[i] <= target; i++) {
                if (i > start && num[i] == num[i-1]) {
                    continue;
                }
                result.add(num[i]);
                solve(results, result, num, i + 1, target - num[i]);
                result.remove(result.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        CombinationSumII test = new CombinationSumII();
        test.combinationSum2(new int[]{1,2}, 4);
    }

}
