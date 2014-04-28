package pointTo;

public class Question42ReverseStringByWord {

	public static void reverse(char[] input, int start, int end) {
		if (start > end || input == null || input.length < 0 || input.length <= end) {
			return;
		}
		
		while (start <= end) {
			char temp = input[start];
			input[start] = input[end];
			input[end] = temp;
			start++;
			end--;
		}
	}
	
	public static String reverseString(String input) {
		if (input == null || input.length() < 0) {
			return null;
		}
		
		char[] temp = input.toCharArray();
		reverse(temp, 0, temp.length - 1);
		int start = 0, end = 0;
		while (start < temp.length) {
			if (temp[start] == ' ') {
				start++;
				end++;
			} else if (end == temp.length || temp[end] == ' ') {
				reverse(temp, start, --end);
				start = ++end;
			} else {
				end++;
			}
		}
		return new String(temp);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String test1 = "I am a testing string";
		System.out.println(reverseString(test1));
		String test2 = "Iamatestingstring";
		System.out.println(reverseString(test2));
		String test3 = "I am    a testing string ";
		System.out.println(reverseString(test3));
		String test4 = null;
		System.out.println(reverseString(test4));
	}

}
