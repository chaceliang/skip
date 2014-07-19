package array;

/**
 * Created by chace on 6/7/14.
 */
public class LocalMinimal {
    // A[i-1] > A[i] && A[i] < A[i+1]
    public static int localMinimal(int[] A) {
        if (A == null) {
            throw new NullPointerException();
        }
        return localMinimal(A, 0, A.length - 1);
    }

    public static int localMinimal(int[] A, int i, int j) {
        if (i == j) {
            return A[i];
        }
        if (j - i == 1) {
            return A[i] < A[j] ? A[i] : A[j];
        }
        int mid = (j - i) / 2;
        if (A[mid-1] > A[mid] && A[mid] < A[mid+1]) {
            return A[mid];
        }
        if (A[mid] > A[mid-1]) {
            return localMinimal(A, i, mid-1);
        } else {
            return localMinimal(A, mid+1, j);
        }
    }

    public static void main(String[] args) {
        System.out.println(localMinimal(new int[]{15, 13, 12, 18, 19, 20, 7, 6, 5, 4, 3, 2, 1}));
    }
}
