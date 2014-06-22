package array;

/**
 * Created by chace on 6/22/14.
 */
public class FindSmallestInRotatedArray {

    public static int findSmallestInRotatedArray(int[] A) {
        if (A == null) {
            throw new NullPointerException();
        }
        int s = 0, e = A.length - 1;
        while (A[s] > A[e]) {
            int mid = (s + e)/2;
            if (A[mid] > A[e]) {
                s = mid + 1;
            } else {
                e = mid;
            }
        }
        return s;
    }
}
