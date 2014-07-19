package pointTo;

public class Question40FindTwoUniqueNumbers {

	public static int findFirstBitIs1(int num) {
		int bitIndex = 0;
		while ((num & 1) == 0) {
			num >>= 1;
			bitIndex++;
		}
		return bitIndex;
	}
	
	public static boolean isIndexBit1(int num, int index) {
		num >>= index;
		return (num & 1) != 0;
	}
	
	public static void findNumbersAppearOnce(int[] num) {
		if (num == null || num.length <= 0) {
			return;
		}
		int  resultExclusiveOR = 0;
		for (int i = 0; i < num.length; i++) {
			resultExclusiveOR ^= num[i];
		}
		int indexOf1 = findFirstBitIs1(resultExclusiveOR);
		int num1 = 0, num2 = 0;
		for (int i = 0; i < num.length; i++) {
			if (isIndexBit1(num[i], indexOf1)) {
				num1 ^= num[i];
			} else {
				num2 ^= num[i];
			}
		}
		System.out.println(num1 + " " + num2);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] test1 = {2,4,3,6,3,2,5,5};
		findNumbersAppearOnce(test1);
	}

}
