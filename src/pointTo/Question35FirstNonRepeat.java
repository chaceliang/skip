package pointTo;

import java.util.HashMap;

public class Question35FirstNonRepeat {
	
	public static char firstNonRepeat(char[] input) {
		if (input == null || input.length <= 0) {
			return '\u0000'; // Empty char
		}
		
		HashMap<Character, Integer> appearence = new HashMap<Character, Integer>();
		
		for (int i = 0; i < input.length; i++) {
			int count = appearence.get(input[i]) == null ? 0 : appearence.get(input[i]);
			appearence.put(input[i], ++count);
		}
		for (int i = 0; i < input.length; i++) {
			int count = appearence.get(input[i]);
			if (count == 1) {
				return input[i];
			}
		}
		return '\u0000';
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		char[] input1 = null;
		char[] input2 = "abaccdeff".toCharArray();
		System.out.println(firstNonRepeat(input1));
		System.out.println(firstNonRepeat(input2));
	}
}
