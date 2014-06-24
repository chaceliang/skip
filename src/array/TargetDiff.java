package array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by chace on 6/7/14.
 */
public class TargetDiff {
    // 一个数组,一个target,求所有的pairs, array[i] - array[j] = k.

    public static ArrayList<Pair> cal(int[] A, int k) {
        ArrayList<Pair> results = new ArrayList<Pair>();
        if (A == null) {
            throw new NullPointerException();
        }

        if (A.length < 2) {
            return results;
        }
        Arrays.sort(A);
        for (int i = 0, j = 1; j < A.length;) {
            if (A[j] - A[i] == k) {
                Pair tmp = new Pair(i, j);
                results.add(tmp);
                j++;
            } else if (A[j] - A[i] > k) {
                i++;
            } else {
                j++;
            }
        }

        return results;
    }

    public static void targetDifference(int[] A, int k) {
        if (A == null || A.length <= 0) {
            return;
        }
        Arrays.sort(A);
        int i = 0, j = A.length - 1;
        while (i < j) {
            int tmp = A[j] - A[i];
            if (tmp == k) {
                System.out.println(i + " " + j);
                return;
            } else if (tmp > k) {
                j--;
            } else {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Pair> results = cal(new int[]{1,2,3,4,5}, 2);
        for (Pair p : results) {
            System.out.println(p.i + ", " + p.j);
        }
    }
}

class Pair {
    int i;
    int j;
    public Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
