package base;

/**
 * Created by chace on 6/18/14.
 */
public class Utils {
    public static void swap(Object[] A, int a, int b) {
        Object tmp = A[a];
        A[a] = A[b];
        A[b] = tmp;
    }

    public static void printArray(Object[] A) {
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
        System.out.println();
    }
}