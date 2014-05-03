package edocteel.array;

public class SortColors {

	public static void sortColors(int[] A) {
		if (A == null || A.length < 0) {
			return;
		}
		int current = 0;
		int zero = 0, two = A.length - 1;
		while (current <= two) {
			if (A[current] == 0) {
				swap(A, current++, zero++);
			} else if (A[current] == 1) {
				current++;
			} else {
				swap(A, current, two--);
			}
		}
	}
	
	public static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
