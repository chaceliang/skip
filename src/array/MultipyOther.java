package array;

/**
 * Created by chace on 7/5/14.
 */
public class MultipyOther {
    /*
    给一个数组，返回一个数组其中每个数是除了之前数组这个index的数以外所有数的乘积，主要就考虑有0的情况
     */

    public static int[] other(int[] A) {
        if (A == null) {
            throw new NullPointerException();
        }
        int len = A.length;
        int[] result = new int[len];
        boolean hasZero = false;
        long r = 1;
        for (int i = 0; i < len; i++) {
            if (A[i] == 0) {
                hasZero = true;
            } else {
                r *= A[i];
            }
        }

        for (int i = 0; i < len; i++) {
            if (hasZero) {
                if (A[i] == 0) {
                    result[i] = (int)r;
                } else {
                    result[i] = 0;
                }
            } else {
                result[i] = (int)r / A[i];
            }
        }
        return result;
    }
}
