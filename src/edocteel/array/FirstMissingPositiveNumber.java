package edocteel.array;

public class FirstMissingPositiveNumber {

    /*
    Given an unsorted integer array, find the first missing positive integer.

    For example,
    Given [1,2,0] return 3,
    and [3,4,-1,1] return 2.

    Your algorithm should run in O(n) time and uses constant space.
     */
	public static int firstMissingPositive(int[] A) {
		if (A == null || A.length <= 0) {
			return 1;
		}
		int i = 0; 
		while (i < A.length) {
			if (A[i] >= 0 && A[i] < A.length && A[i] != i && A[i] != A[A[i]]) {
				int temp = A[A[i]];
				A[A[i]] = A[i];
				A[i] = temp;
				continue;
			}
			i++;
		}
		for (i = 1; i < A.length; i++) {
			if (A[i] != i) {
				return i;
			}
		}
		
		// Case: [3,1,2]
		if (A[0] ==  A.length) {
			return A.length + 1;
		}
		// Case: [0,1,2,3], [5,1,2,3]
		return A.length;
	}

	public static void main(String[] args) {
		System.out.println(firstMissingPositive(new int[] {1,0}));
	}

}
