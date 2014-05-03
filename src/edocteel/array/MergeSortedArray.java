package edocteel.array;

import java.util.Arrays;

public class MergeSortedArray {

	public static void merge(int A[], int m, int B[], int n) {
		if (m == 0 && n > 0) {
			int i = 0;
			while (i < n) {
				A[i] = B[i++];
			}
		}
		if (m > 0 && n == 0) {
			return;
		}
		int iA = m - 1;
		int iB = n - 1;
		int iMerge = m + n - 1;
		while (iB >= 0 && iA >= 0) {
			if (A[iA] > B[iB]) {
				A[iMerge] = A[iA];
				iA--;
			} else {
				A[iMerge] = B[iB];
				iB--;
			}
			iMerge--;
		}
		if (iA < 0) {
			while (iB >= 0) {
				A[iMerge--] = B[iB--];
			}
		}
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = new int[] {0};
		int[] B = new int[] {1};
		merge(A, 1, B, 1);
	}

}
