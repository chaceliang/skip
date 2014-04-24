package pointTo;

public class Question8FindMinInRotatedArray {
	
	public static int findMinInorder(int[] input, int start, int end) {
		int t = input[start];
		for (int i = start + 1; i <= end; i++) {
			if (t > input[i]) {
				t = input[i];
			}
		}
		return t;
	}
	
	public static int findMin(int[] input) {
		if (input == null || input.length <= 0) {
			return -1;
		}
		int start = 0;
		int end = input.length - 1;
		int mid = 0;
		while (input[start] >= input[end]) {
			if (end - start == 1) {
				mid = end;
				break;
			}
			mid = (start + end) / 2;
			if (input[start] == input[end] && input[start] == input[mid]) {
				return findMinInorder(input, start, end);
			}
			if (input[start] <= input[mid]) {
				start = mid;
			} else if (input[mid] <= input[end]) {
				end = mid;
			}
		}
		return input[mid];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] test1 = {3,4,5,1,2};
		int[] test2 = {1,2,3,4,5};
		int[] test3 = null;
		int[] test4 = {0,0,1,1,1};
		int[] test5 = {1,0,0,1,1};
		
		System.out.println(findMin(test1));
		System.out.println(findMin(test2));
		System.out.println(findMin(test3));
		System.out.println(findMin(test4));
		System.out.println(findMin(test5));

	}

}
