package pointTo;

public class Question36ReversePair {
	
	static int count = 0;
	
	public static void mergeArray(int[] input, int first, int mid, int last) {
		int i = first, j = mid + 1;
		int m = mid, n = last;
		int k = first;
        int[] tm = new int[last+1];
		while (i <= m || j <= n) {
            if (i <= m && j <= n) {
                if (input[i] > input[j]) {
                    tm[k++] = input[j++];
                    count += mid - i + 1;
                } else {
                    tm[k++] = input[i++];
                }
            } else if (i <= m) {
                tm[k++] = input[i++];
            } else if (j <= n) {
                tm[k++] = input[j++];
            }
		}

		for (i = first; i <= last; i++) {
			input[i] = tm[i];
		}
	}
	
	public static void mergeSort(int[] input, int first, int last) {
		if (first < last) {
			int mid = (first + last) / 2;
			mergeSort(input, first, mid);
			mergeSort(input, mid + 1, last);
			mergeArray(input, first, mid, last);
		}
	}
	
	public static void mergeSort(int[] input) {
		mergeSort(input, 0, input.length - 1);
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
