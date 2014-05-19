package edocteel.miscellaneous;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by chace on 5/7/14.
 */
public class PascalTriangle {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if (numRows <= 0) {
            return results;
        }
        ArrayList<Integer> previous = new ArrayList<Integer>();
        for (int i = 1; i <= numRows; i++) {
            ArrayList<Integer> result = new ArrayList<Integer>();
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i - 1) {
                    result.add(1);
                } else {
                    result.add(previous.get(j-1) + previous.get(j));
                }
            }
            previous = result;
            results.add(result);
        }
        return results;
    }
}
