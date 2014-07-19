package edocteel.dp;

/**
 * Created by chace on 5/10/14.
 */
public class JumpGame {

    public boolean canJump(int[] A) {
        if (A == null || A.length <= 0) {
            return false;
        }

        int[] jump = new int[A.length];
        jump[0] = 0;
        for (int i = 1; i < A.length; i++) {
            jump[i] = Math.max(jump[i-1], A[i-1]) - 1;
            if (jump[i] < 0) {
                return false;
            }
        }
        return jump[A.length - 1] >= 0;
    }

    public boolean canJump1(int[] A) {
        if (A == null || A.length <= 0) {
            return false;
        }
        int maxCover = 0;
        for (int i = 0; i <= maxCover && i < A.length; i++) {
            if (A[i] + i > maxCover) {
                maxCover = A[i] + i;
            }
            if (maxCover >= A.length - 1) {
                return true;
            }
        }
        return false;
    }

}
