package edocteel.recursion;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by chace on 5/8/14.
 */
public class SubsetsII {

    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> prevLevel = null;
        Arrays.sort(num);
        results.add(new ArrayList<Integer>());
        for (int i = 0; i < num.length; i++) {
            ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
            ArrayList<ArrayList<Integer>> p = i == 0 || num[i] != num[i-1] ? results : prevLevel;
            for (ArrayList<Integer> r : p) {
                ArrayList<Integer> result = new ArrayList<Integer>(r);
                result.add(num[i]);
                temp.add(result);
            }
            results.addAll(temp);
            prevLevel = temp;
        }
        return results;
    }
}
