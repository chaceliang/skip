package pointTo;

public class Question12PrintMaxN {
	
	public static void printMaxN(int n) {
		if (n <= 0) {
			return;
		}
		int[] result = new int[n];
		for (int i = 0; i < 10; i++) {
			result[0] = i;
			print1ToMax(result, 0);
		}
	}
	
	public static void print1ToMax(int[] result, int index) {
		if (index == result.length - 1) {
			print(result);
			return;
		}
		for (int i = 0; i < 10; i++) {
			result[index+1] = i;
			print1ToMax(result, index+1);
		}
	}
	
	public static void print(int[] result) {
		boolean isBeginning0 = true;
		for (int i = 0; i < result.length; i++) {
			if (isBeginning0 && result[i] > 0) {
				isBeginning0 = false;
			}
			if (!isBeginning0) {
				System.out.print(result[i]);
			}
		}
		System.out.println();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printMaxN(3);
	}

}
