package edocteel.array;

public class SearchForARange {

    /*
    Given a sorted array of integers, find the starting and ending position of a given target value.

    Your algorithm's runtime complexity must be in the order of O(log n).

    If the target is not found in the array, return [-1, -1].

    For example,
    Given [5, 7, 7, 8, 8, 10] and target value 8,
    return [3, 4].
     */
	public static int[] searchRange(int[] A, int target) {
        int start = -1, end = -1;
        if (A == null || A.length <= 0) {
            return new int[] {start, end};
        }

        int i = 0, j = A.length - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (A[mid] >= target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        if (i < A.length && A[i] == target) {
            start = i;
        }

        j = A.length - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (A[mid] <= target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        if (j >= 0 && A[j] == target) {
            end = j;
        }

        return new int[] {start, end};
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] A = {5, 7, 7, 8, 8, 10};
        searchRange(A, 8);
	}

}
