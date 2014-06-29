package array;

import java.util.Arrays;

/**
 * Created by chace on 6/17/14.
 */
public class PrintTriangle {

    public static void printTriangle(int N) {
        if (N <= 0) {
            return;
        }
        int[] A = new int[N];
        A[0] = 1;
        for (int i = 0; i < N; i++) {
            int[] prev = A.clone();
            for (int j = 1; j <= i - 1; j++) {
                A[j] = prev[j-1] + prev[j];
            }
            A[i] = 1;
            prev = A;
            for (int k = 0; k <= i; k++) {
                System.out.print(A[k] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printTriangle(9);
    }
}
