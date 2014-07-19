package math;

import java.util.ArrayList;

/**
 * Created by chace on 7/4/14.
 */
public class AllFactors {

    public ArrayList<ArrayList<Integer>> allFactors(int n) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if (n <= 0) {
            return results;
        }
        util(n, 2, new ArrayList<Integer>(), results);
        return results;
    }

    public void util(int n, int i, ArrayList<Integer> result, ArrayList<ArrayList<Integer>> results) {
        if (n == 1) {
            result.add(0, n);
            results.add(new ArrayList<Integer>(result));
            result.remove(result.size() - 1);
        } else {
            for (; i <= n; i++) {
                if (n % i == 0) {
                    result.add(i);
                    util(n / i, i+1, result, results);
                    result.remove(result.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        AllFactors test = new AllFactors();
        ArrayList<ArrayList<Integer>> results = test.allFactors(24);
        for (ArrayList<Integer> result : results) {
            System.out.println(result);
        }
    }
}
