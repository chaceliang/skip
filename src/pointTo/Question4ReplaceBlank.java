package pointTo;

public class Question4ReplaceBlank {
	
	public static char[] replaceBlank(char[] input) {
		int endOfOriginal = 0;
		int lengthOfOriginal = input.length - 1;
		int countOfSpace = 0;
		while (endOfOriginal <= lengthOfOriginal) {
			if (input[endOfOriginal++] == ' ') {
				countOfSpace++;
			}
		}
		endOfOriginal--;
		int newLength = input.length + countOfSpace * 2;
		char[] output = new char[newLength];
		int endOfNew = output.length - 1;
		while (endOfOriginal >= 0) {
			if (input[endOfOriginal] == ' ') {
				output[endOfNew--] = '0';
				output[endOfNew--] = '2';
				output[endOfNew--] = '%';
			} else {
				output[endOfNew--] = input[endOfOriginal];
			}
			endOfOriginal--;
		}
		
		return output;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		char[] test1 = "hello world".toCharArray();
		System.out.println(replaceBlank(test1));
		char[] test2 = "hello world ".toCharArray();
		System.out.println(replaceBlank(test2));
		char[] test3 = "world".toCharArray();
		System.out.println(replaceBlank(test3));
		char[] test4 = "".toCharArray();
		System.out.println(replaceBlank(test4));
	}

}
