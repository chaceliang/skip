package array;

/**
 * Created by chace on 6/4/14.
 */
public class FindNumberAppearMoreThanHalf {

    public static boolean checkForHalf(int[] A, int target) {
        int times = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == target) {
                times++;
            }
        }
        return times > A.length / 2;
    }

    public static int findNumberAppearMoreThanHalf(int[] A) {
        if (A == null || A.length <= 0) {
            return -1;
        }
        int result = A[0];
        int times = 1;
        for (int i = 0; i < A.length; i++) {
            if (times == 0) {
                result = A[i];
                times = 1;
            } else if (A[i] == result) {
                times++;
            } else {
                times--;
            }
        }
        if (!checkForHalf(A, result)) {
            return -1;
        }
        return result;
    }
}
