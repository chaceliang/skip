package array;

/**
 * Created by chace on 5/28/14.
 */
public class FindMajority {

    public static Integer findMajority(int[] A) {
        if (A == null || A.length <= 0) {
            return null;
        }
        int majority = 0, count = 1, len = A.length;
        for (int i = 1; i < len; i++) {
            if (count == 0) {
                majority = i;
                count = 1;
            } else if (A[majority] == A[i]) {
                count++;
            } else {
                count--;
            }
        }
        count = 0;
        for (int i = 0; i < len; i++) {
            if (A[majority] == A[i]) {
                count++;
            }
            if (len - count < count) {
                return A[majority];
            }
        }
        return null;
    }
}
