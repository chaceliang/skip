package edocteel.recursion;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by chace on 5/4/14.
 */
public class CombinationSum {

    public static ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(candidates);
        addUp(candidates, 0, target, new ArrayList<Integer>(), results);
        return results;
    }

    public static void addUp(int[] candidates, int start, int target, ArrayList<Integer> paths, ArrayList<ArrayList<Integer>> results) {
        if (start < 0 || target < 0) {
            return;
        }
        if (target == 0) {
            ArrayList<Integer> res = new ArrayList<Integer>(paths);
            results.add(res);
        } else {
            for (int i = start; i < candidates.length && candidates[i] <= target; i++) {
                paths.add(candidates[i]);
                addUp(candidates, i, target - candidates[i], paths, results);
                paths.remove(paths.size() - 1);
            }
        }
    }

    public ArrayList<ArrayList<Integer>> combinationSum1(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        int[] indexes = new int[1000000];
        indexes[0] = 0;
        Arrays.sort(candidates);
        solve(results, 0, candidates, indexes, target, 0);
        return results;
    }

    public void solve(ArrayList<ArrayList<Integer>> results, int sum, int[] candidates, int[] indexes, int target, int index) {
        if (sum == target) {
            addResult(results, candidates, indexes, index);
        } else if (sum > target) {
            return;
        } else {
            for (int i = indexes[index]; i < candidates.length; i++) {
                indexes[index + 1] = i;
                solve(results, sum + candidates[i], candidates, indexes, target, index+1);
            }
        }
    }

    public void addResult(ArrayList<ArrayList<Integer>> results, int[] candidates, int[] index, int n) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            result.add(candidates[index[i]]);
        }
        results.add(result);
    }
}
