package pointTo;

public class FindIn2DArray {

	public static boolean findIn2DArray(int[][] input, int target) {
		boolean found = false;
		if (input == null) {
			return found;
		}
		int row = input.length - 1;
		int col = input[0].length - 1;
		if (row < 0 || col < 0) {
			return found;
		}
		int s = 0, e = col;
		while (s < e) {
			if (s == e && input[row][s] != target) {
				break;
			}
			int mid = (s + e) / 2;
			if (input[row][mid] == target) {
				found = true;
				return found;
			} else if (input[row][mid] > target) {
				e = mid;
			} else {
				s = mid + 1;
			}
		}
		col = s;
		s = 0;
		e = row;
		while (s <= e) {
			if (s == e && input[s][col] != target) {
				break;
			}
			int mid = (s + e) / 2;
			if (input[mid][col] == target) {
				found = true;
				return found;
			} else if (input[mid][col] > target) {
				e = mid;
			} else {
				s = mid + 1;
			}
		}
		return found;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] input1 = {
				{1,2,8,9},
				{3,9,10,12},
				{4,10,11,13},
				{6,12,13,15}
		};
		int[][] input2 = {
				{1,2,8,9}
		};
		int[][] input3 = {
				{1},
				{2},
				{4},
				{6}
		};
		for (int i = 0; i < 20; i++) {
			System.out.println(i + ": " + findIn2DArray(input1, i));
		}
		System.out.println();
		for (int i = 0; i < 20; i++) {
			System.out.println(i + ": " + findIn2DArray(input2, i));
		}
		System.out.println();
		for (int i = 0; i < 20; i++) {
			System.out.println(i + ": " + findIn2DArray(input3, i));
		}
	}

}
