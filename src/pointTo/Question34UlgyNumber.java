package pointTo;

public class Question34UlgyNumber {

	public static int min(int a, int b, int c) {
		int min = a < b ? a : b;
		min = min < c ? min : c;
		return min;
	}
	
	public static int uglyNumber(int index) {
		if (index <= 0) {
			return 0;
		}
		int[] uglyNumbers = new int[index+1];
		uglyNumbers[0] = 1;
		int uglyIndex = 1;
		
		int next2 = 2;
		int next3 = 3;
		int next5 = 5;
		
		int index2 = 1;
		int index3 = 1;
		int index5 = 1;
		
		while (uglyIndex <= index) {
			int min = min(next2, next3, next5);
			uglyNumbers[uglyIndex++] = min;
			if (next2 == min) {
				next2 = uglyNumbers[index2++] * 2;
			}
			if (next3 == min) {
				next3 = uglyNumbers[index3++] * 3;
			}
			if (next5 == min) {
				next5 = uglyNumbers[index5++] * 5;
			}
		}
		return uglyNumbers[index];
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(uglyNumber(i));
		}
	}

}
