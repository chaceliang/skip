package edocteel.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by chace on 5/8/14.
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        results.add(new ArrayList<Integer>());
        Arrays.sort(S);
        for (int i = 0; i < S.length; i++) {
            int size = results.size();
            for (int j = 0; j < size; j++) {
                ArrayList<Integer> result = new ArrayList<Integer>(results.get(j));
                result.add(S[i]);
                results.add(result);
            }
        }
        return results;
    }
}
