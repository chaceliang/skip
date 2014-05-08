package edocteel.miscellaneous;

/**
 * Created by chace on 5/7/14.
 */
public class SingleNumberII {
    public int singleNumber(int[] A) {
        int[] bits = new int[32];
        if (A == null || A.length <= 0) {
            return -1;
        }
        for (int i = 0; i < A.length; i++) {
            int k = 1;
            for (int j = 0; j < 32; j++) {
                int bit = (A[i] >> j);
                bits[j] += bit & k;
            }
        }
        int target = 0;
        for (int i = 0; i < 32; i++) {
            target += (bits[i] % 3 << i);
        }
        return target;
    }
}
