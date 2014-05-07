package edocteel.miscellaneous;

import java.util.ArrayList;

/**
 * Created by chace on 5/7/14.
 */
public class GrayCode {
    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (n < 0) {
            return result;
        }
        result.add(0);
        if (n == 0) {
            return result;
        }
        result.add(1);
        if (n == 1) {
            return result;
        }
        ArrayList<Integer> prevResult = new ArrayList<Integer>();
        for (int i = 2; i <= n; i++) {
            for (Integer in : result) {
                prevResult.add(in);
            }
            for (int j = result.size() - 1; j >= 0; j--) {
                prevResult.add((int)(result.get(j) + Math.pow(2, i-1)));
            }
            result = prevResult;
            prevResult = new ArrayList<Integer>();
        }
        return result;
    }
}
