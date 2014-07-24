package array;

/**
 * Created by Chace on 7/20/14.
 */
public class SumSmall {

    // n^(k-1) * lgn
    public static int binarySearch(int[] A, int lo, int hi, int T) {
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (A[mid] >= T) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return hi;
    }

    public static void twoSumSmall1(int[] A, int N) {
        int max = A.length - 1;
        for (int i = 0; i < A.length; i++) {
            int T = N - A[i];
            int index = binarySearch(A, i+1, max, T);
            if (index < max) {
                max = index;
            }
            for (int j = i+1; j <= max; j++) {
                System.out.println(A[i] + " + " + A[j] + " = " + (A[i] + A[j]));
            }
        }
    }

    // Should have some better solutions. this is n2
    public static void twoSumSmall(int[] A, int N) {
        if (A == null) {
           throw new NullPointerException();
        }
        int len = A.length;
        int farest = len-1;
        for (int i = 0; i <= farest; i++) {
            for (int j = i+1; j <= farest; j++) {
                if (A[i] + A[j] <= N) {
                    System.out.println(A[i] + " + " + A[j] + " = " + (A[i] + A[j]));
                } else {
                    farest = j;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] A = {1,3,4,5,7,8,10};
        twoSumSmall(A, 8);
        System.out.println();
        twoSumSmall1(A, 8);
    }
}
