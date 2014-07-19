package array;

/**
 * Created by chace on 5/27/14.
 */
public class FindMax {

    public static int findMax(int[] A) {
        if (A == null || A.length <= 0) {
            return -1;
        }
        int len = A.length;
        int i = 0, j = len - 1;
        while (i <= j) {
            int mid = (i+j) / 2;
            if (mid == 0 || mid == len - 1) {
                return mid == 0 ? Math.max(A[mid], A[mid+1]) : Math.max(A[mid], A[mid-1]);
            }
            if (A[mid] > A[mid-1] && A[mid] > A[mid+1]) {
                return A[mid];
            } else if (A[mid-1] < A[mid] && A[mid] < A[mid+1]) {
                i = mid+1;
            } else if (A[mid-1] > A[mid] && A[mid] > A[mid+1]) {
                j = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] A = {1,2,3,4,5,6,4,3,2};
        System.out.println(findMax(A));
        int[] B = {1,2,3,4,5,4};
        System.out.println(findMax(B));
        int[] C = {4,5,4,3,2};
        System.out.println(findMax(C));
        int[] D = {1,2,3,4,5};
        System.out.println(findMax(D));
        int[] E = {1,2,3,4,5};
        System.out.println(findMax(E));
    }
}
