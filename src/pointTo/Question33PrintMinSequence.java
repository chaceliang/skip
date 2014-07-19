package pointTo;

import java.util.Arrays;
import java.util.Comparator;

public class Question33PrintMinSequence {

	public static void printMinSequence(int[] input) {
		if (input == null || input.length <= 0) {
			return;
		}
		int length = input.length;
		String[] convertInput = new String[length];
		for (int i = 0; i < length; i++) {
			convertInput[i] = Integer.toString(input[i]);
		}
		
		Arrays.sort(convertInput, new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				String ab = a + b;
				String ba = b + a;
				return ab.compareTo(ba);
			}
		});
		
		for (int i = 0; i < length; i++) {
			System.out.print(convertInput[i]);
		}
		System.out.println();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] input1 = {3,32,321};
		printMinSequence(input1);
	}

}
