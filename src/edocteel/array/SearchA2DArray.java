package edocteel.array;

public class SearchA2DArray {

	public boolean searchMatrix1(int[][] matrix, int target) {
		int length = matrix.length;
		if (length == 0)
			return false;
		int width = matrix[0].length;
		int low = 0;
		int high = width * length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			int x = mid / width;
			int y = mid % width;
			if (matrix[x][y] == target)
				return true;
			else if (matrix[x][y] > target) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return false;
	}

    // 每行元素不一定都比前一行大
    public boolean searchMatrix2(int[][] matrix, int target) {
        int i = 0, j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
	
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
		if (matrix.length == 1) {
			return searchRow(matrix[0], target);
		}
		int row = 0;
		for (row = 0; row < matrix.length; row++) {
			if (matrix[row][0] == target) {
				return true;
			} else if (matrix[row][0] > target) {
				break;
			}
		}
		if (row == 0) {
			return false;
		} else {
			row--;
			return searchRow(matrix[row], target);
		}
    }
	
	public boolean searchRow(int[] row, int target) {
		if (row == null || row.length <= 0) {
			return false;
		}
		int start = 0, end = row.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (row[mid] == target) {
				return true;
			} else if (row[mid] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return false;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SearchA2DArray test = new SearchA2DArray();
		int[][] input1 = {
				{1},
				{3},
		};
		test.searchMatrix(input1, 0);
	}

}
