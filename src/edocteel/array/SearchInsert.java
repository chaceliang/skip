package edocteel.array;

public class SearchInsert {

	public int searchInsert(int[] A, int target) {
        if (A == null || A.length <= 0) {
            return 0;
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] >= target) {
                return i;
            }
        }
        return A.length;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
