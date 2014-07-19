package edocteel.recursion;

import java.util.ArrayList;

/**
 * Created by chace on 5/10/14.
 */
public class Combinations {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if (n <= 0 || k <= 0) {
            return results;
        }
        helper(results, new ArrayList<Integer>(), 1, n, k);
        return results;
    }

    public void helper(ArrayList<ArrayList<Integer>> results, ArrayList<Integer> result, int m, int n, int k) {
        if (result.size() == k) {
            results.add((ArrayList<Integer>) result.clone());
            return;
        }
        for (int i = m; i <= n; i++) {
            result.add(i);
            helper(results, result, i+1, n, k);
            result.remove(result.size() - 1);
        }
    }

    public static void main(String[] args) {
    }
}
