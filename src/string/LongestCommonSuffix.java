package string;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by chace on 6/5/14.
 */
public class LongestCommonSuffix {
    public static List<Integer> commonSuffix(List<Integer> l1, List<Integer> l2) {
        int len1 = l1.size(), len2 = l2.size();
        int i1 = 0, i2 = 0;
        if (len1 > len2) {
            i1 = len1 - len2;
        } else {
            i2 = len2 - len1;
        }
        while (i1 < len1 && i2 < len2) {
            if (l1.get(i1) == l2.get(i2)) {
                return l1.subList(i1, len1);
            }
            i1++; i2++;
        }
        return null;
    }

    public static void main(String[] args) {
        int[] t1 = new int[] {1,2,3,4,5,6,7,8,9};
        List<Integer> l1 = new LinkedList<Integer>();
        for (int i = 0; i < t1.length; i++) l1.add(t1[i]);

        int[] t2 = new int[] {5,6,7,8,9};
        List<Integer> l2 = new LinkedList<Integer>();
        for (int i = 0; i < t2.length; i++) l2.add(t2[i]);

        List<Integer> result = commonSuffix(l1, l2);
        for (Integer i : result) {
            System.out.println(i);
        }
    }
}
