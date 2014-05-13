package edocteel.miscellaneous;

/**
 * Created by chace on 5/12/14.
 */
public class TrappingRainWater {

    public int trap(int[] A) {
        if (A == null || A.length <= 2) {
            return 0;
        }
        int length = A.length;
        int[] l = new int[length];
        int[] r = new int[length];

        int max = A[0];
        l[0] = 0;
        for (int i = 1; i < length - 1; i++) {
            l[i] = max;
            if (A[i] > max) {
                max = A[i];
            }
        }
        max = A[length - 1];
        r[length - 1] = 0;
        int ctrap = 0, ttrap = 0;
        for (int i = length - 2; i > 0; i--) {
            r[i] = max;
            ctrap = Math.min(l[i], r[i]) - A[i];
            if (ctrap > 0) {
                ttrap += ctrap;
            }
            if (max < A[i]) {
                max = A[i];
            }
        }
        return ttrap;
    }
}
