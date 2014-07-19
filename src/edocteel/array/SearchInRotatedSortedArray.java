package edocteel.array;

public class SearchInRotatedSortedArray {

	public int search(int[] A, int target) {
		if (A == null || A.length <= 0) {
			return -1;
		}
		int start = 0, end = A.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (A[mid] == target) {
				return mid;
			}
			if (A[mid] >= A[end]) { // left part sorted
				if (A[start] <= target && target < A[mid]) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			} else { // right part sorted
				if (A[mid] < target && target <= A[end]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
		}
		return -1;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
