package array;

/**
 * Created by Chace on 7/20/14.
 */
public class LongestCircle {
    /*
     * 索引 0 1 2 3 4
     * 值   3 2 1 4 0
     * 数组的值是下次跳的索引位置，这样的话数组有环，比如 0 -> 3 -> 4 -> 0  1 -> 2 -> 1， 求最长环的长度.
     * 确保不会有两个数指向同一个索引
     */

    public static int longestCircle(int[] A) {
        if (A == null) {
            throw new NullPointerException();
        }
        int r = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != -1) {
                int j = A[i];
                A[i] = -1;
                count = 1;
                while (A[j] != -1) {
                    int t = A[j];
                    count++;
                    A[j] = -1;
                    j = t;
                }
                if (count > r) {
                    r = count;
                }
            }
        }
        return r;
    }

    public static void main(String[] args) {
        int[] A = {3,2,1,4,0};
        System.out.println(longestCircle(A));
    }
}
