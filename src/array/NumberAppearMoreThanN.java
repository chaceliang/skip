package array;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Created by chace on 7/5/14.
 */
public class NumberAppearMoreThanN {
    /*
    Given an array of of size n and a number k, find all elements that appear more than n/k times.
     */

    public static void find(int[] A, int k) {
        if (A == null) {
            throw new NullPointerException();
        }
        Hashtable<Integer, Integer> counter = new Hashtable<Integer, Integer>();
        int len = A.length;
        for (int i = 0; i < len; i++) {
            if (counter.containsKey(A[i])) {
                counter.put(A[i], counter.get(A[i]) + 1);
            } else if (counter.size() < k-1) {
                counter.put(A[i], 1);
            } else if (counter.size() >= k-1) {
                ArrayList<Integer> toRemove = new ArrayList<Integer>();
                for (Integer key : counter.keySet()) {
                    counter.put(key, counter.get(key) - 1);
                    if (counter.get(key) == 0) {
                        toRemove.add(key);
                    }
                }
                for (Integer key : toRemove) {
                    counter.remove(key);
                }
            }
        }
        for (Integer key : counter.keySet()) {
            int times = 0;
            for (int i = 0; i < len; i++) {
                if (A[i] == key) {
                    times++;
                }
            }
            if (times > len / k) {
                System.out.println(key);
            }
        }
    }

    public static void main(String[] args) {
        int[] A =  {3, 1, 2, 2, 1, 2, 3, 3, 3};
        find(A, 3);
    }
}
