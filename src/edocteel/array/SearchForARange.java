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
	public int[] searchRange(int[] A, int target) {
        int start = -1, end = -1;
        if (A == null || A.length <= 0) {
            return new int[] {start, end};
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] == target) {
                if (start == -1) {
                    start = i;
                    end = i;
                } else {
                    end = i;
                }
            } 
        }
        return new int[] {start, end};
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
