package company.google;

import java.util.*;

/**
 * Created by chace on 6/5/14.
 */
public class RemoveDuplicateFrom {
    public static List<String> removeDup(List<String> input) {
        if (input == null || input.size() <= 0) {
            throw new NoSuchElementException();
        }
        Set<String> cache = new HashSet<String>();
        List<String> result = new ArrayList<String>();
        for (String str : input) {
            if (!cache.contains(str)) {
                result.add(str);
                cache.add(str);
            }
        }
        return result;
    }
}
