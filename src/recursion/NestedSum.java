package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chace on 6/1/14.
 */
public class NestedSum {

    public int nestedSum(List<NestedInteger> input) {
        return nestedSum(input, 1);
    }

    public int nestedSum(List<NestedInteger> input, int level) {
        int sum = 0;
        for (int i = 0; i < input.size(); i++) {
            NestedInteger tmp = input.get(i);
            if (tmp.isInteger()) {
                sum += tmp.getInteger() * level;
            } else {
                sum += nestedSum(tmp.getList(), level+1);
            }
        }
        return sum;
    }
}

interface NestedInteger {
    // Returns true if this NestedInteger holds a single integer, rather than a nested list
    public boolean isInteger();

    // Returns the single integer that this NestedInteger holds, if it holds a single integer
    // Returns null if this NestedInteger holds a nested list
    public Integer getInteger();

    // Returns the nested list that this NestedInteger holds, if it holds a nested list
    // Returns null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}