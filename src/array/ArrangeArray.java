package array;

import base.Utils;

/**
 * Created by chace on 6/18/14.
 */
public class ArrangeArray {
    /*
    Arrange the numbers in an array in alternating order.
    For example if the array is [a1, a2, a3, a4.. ]arrange the array such that b1<=b2>=b3<=b4 and so on.
    Sample Input: 3 5 7 8 4 9
    Sample Output: 3 < 5 > 4 < 8 >7 < 9
     */

    public static void arrange(Integer[] A) {
        int n = A.length;
        for (int i = 1; i < n; i++) {
            if (i % 2 != 0 && A[i] < A[i - 1]) {
                Utils.swap(A, i, i-1);
            } else if (i % 2 == 0 && A[i] > A[i - 1]) {
                Utils.swap(A, i, i-1);
            }
        }
    }

    public static void main(String[] args) {
        Integer[] A = {100, 7, 5, 8, 4, 9};
        arrange(A);
        Utils.printArray(A);
    }
}
