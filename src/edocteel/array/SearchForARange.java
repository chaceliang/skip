package edocteel.array;

public class SearchForARange {

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
