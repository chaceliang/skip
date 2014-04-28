package pointTo;

public class Question38GetNumberOfK {

	public static int getFirstK(int[] input, int k, int start, int end) {
		if (start > end) {
			return -1;
		}
		
		int middleIndex = (start + end) / 2;
		if (middleIndex == 8) {
			System.out.println();
		}
		int middleValue = input[middleIndex];
		if (middleValue == k) {
			if ((middleIndex > 0 && input[middleIndex - 1] != k) || middleIndex == 0) {
				return middleIndex;
			} else {
				end = middleIndex - 1;
			}
		} else if (middleValue > k) {
			end = middleIndex - 1;
		} else {
			start = middleIndex + 1;
		}
		return getFirstK(input, k, start, end);
	}
	
	public static int getLastK(int[] input, int k, int start, int end) {
		if (start > end) {
			return -1;
		}
		
		int middleIndex = (start + end) / 2;
		int middleValue = input[middleIndex];
		if (middleValue == k) {
			if ((middleIndex < input.length - 1 && input[middleIndex + 1] != k) || middleIndex == input.length - 1) {
				return middleIndex;
			} else {
				start = middleIndex + 1;
			}
		} else if (middleValue > k) {
			end = middleIndex - 1;
		} else {
			start = middleIndex + 1;
		}
		return getLastK(input, k, start, end);
	}
	
	public static int getNumberOfK(int[] input, int k) {
		if (input == null || input.length <= 0) {
			return 0;
		}
		int firstK = getFirstK(input, k, 0, input.length - 1);
		int lastK = getLastK(input, k, 0, input.length - 1);
		
		if (firstK > -1 && lastK > -1) {
			return lastK - firstK + 1;
		}
		return 0;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] input1 = {1,2,3,3,3,3,4,5};
		System.out.println(getNumberOfK(input1, 3));
		System.out.println(getNumberOfK(input1, 6));
		System.out.println(getNumberOfK(input1, 2));
		System.out.println(getNumberOfK(input1, 0));
	}

}
