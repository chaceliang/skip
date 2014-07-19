package edocteel.array;

public class SearchInRotatedSortedArrayII {

	public boolean search(int[] A, int target) {
		if (A == null || A.length <= 0) {
			return false;
		}
		int start = 0, end = A.length - 1;
		int mid = 0;
		while (start <= end) {
			mid = (start + end) / 2;
			if (A[mid] == target) {
				return true;
			} 
			if (A[start] == A[mid]) {
				if (A[mid] == A[end]) {
					for (int i = start + 1; i < end; i++) {
						if (A[i] == target) {
							return true;
						}
					}
					return false;
				} else if (A[mid] < A[end]) {
					if (A[mid] < target && target <= A[end]) {
						start = mid + 1;
					} else {
						return false;
					}
				} else {
					start = mid + 1;
				}
			} else if (A[start] < A[mid]) {// left part sorted
				if (A[start] <= target && target < A[mid]) {
					end = mid - 1; 
				} else {
					start = mid + 1;
				}
			} else {
				if (A[mid] < target && target <= A[end]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
				
		}
		return false;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
