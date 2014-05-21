package edocteel.recursion;

import java.util.ArrayList;

/**
 * Created by chace on 5/5/14.
 */
public class GenerateParentheses {
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> results = new ArrayList<String>();
        if (n <= 0) {
            return results;
        }
        helper(results, n, n, 0, "");
        return results;
    }

    public void helper(ArrayList<String> results, int left, int right, int sum, String result) {
        if (left == 0 && right == 0 && sum == 0) {
            results.add(result);
        } else if (left < 0 || right < 0 || sum < 0) {
            return;
        } else {
            helper(results, left-1, right, sum+1, result + "(");
            if (sum > 0) {
                helper(results, left, right-1, sum-1, result + ")");
            }
        }
    }
}
