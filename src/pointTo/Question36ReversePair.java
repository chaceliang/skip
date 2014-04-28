package pointTo;

public class Question36ReversePair {
	
	static int count = 0;
	
	public static void mergeArray(int[] input, int first, int mid, int last, int[] tmp) {
		int i = first, j = mid + 1;
		int m = mid, n = last;
		int k = 0;
		while (i <= m && j <= n) {
			if (input[i] > input[j]) {
				tmp[k++] = input[j++];
				count += mid - i + 1;
			} else {
				tmp[k++] = input[i++];
			}
		}
		
		while (i <= m) {
			tmp[k++] = input[i++];
		}
		while (j <= n) {
			tmp[k++] = input[j++];
		}
		for (i = 0; i < k; i++) {
			input[first + i] = tmp[i];
		}
	}
	
	public static void mergeSort(int[] input, int first, int last, int[] tmp) {
		if (first < last) {
			int mid = (first + last) / 2;
			mergeSort(input, first, mid, tmp);
			mergeSort(input, mid + 1, last, tmp);
			mergeArray(input, first, mid, last, tmp);
		}
	}
	
	public static void mergeSort(int[] input) {
		mergeSort(input, 0, input.length - 1, new int[input.length]);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] input = {4,3,2,1};
		mergeSort(input);
		for (int i = 0; i < input.length; i++)
			System.out.println(input[i]);
		System.out.println(count);
	}

}
