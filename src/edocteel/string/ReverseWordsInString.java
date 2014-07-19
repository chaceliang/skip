package edocteel.string;

public class ReverseWordsInString {

	public String reverse(char[] input, int start, int end) {
		int s = start, e = end;
        while (start <= end) {
            char temp = input[start];
            input[start] = input[end];
            input[end] = temp;
            start++;
            end--;
        }
        return new String(input, s, e - s + 1);
    }
    
    public String reverseWords(String s) {
        if (s == null) {
            return "";
        }
        s = s.trim();
        if (s.length() <= 0) {
        	return "";
        }
        char[] array = s.toCharArray();
        StringBuilder builder = new StringBuilder();
        reverse(array, 0, array.length-1);
        int start = 0, end = 0;
        while (start < s.length()) {
            while (array[start] == ' ') {
                start++; end++;
            } 
            if (end == array.length || array[end] == ' ') {
                builder.append(reverse(array, start, --end));
                builder.append(" ");
                start = ++end;
            } else {
                end++;
            }
        }
        return builder.toString().trim();
    }

    public String reverseWords2(String s) {
        if (s == null) {
            return s;
        }
        s = s.trim();
        if (s.length() <= 0) return s;

        int len = s.length();
        char[] array = s.toCharArray();
        reverse(array, 0, len-1);
        int i = 0, j = 0;
        StringBuilder builder = new StringBuilder();

        while (i < len) {
            while (array[i] == ' ') {
                i++; j++;
            }
            if (j == len || array[j] == ' ') {
                builder.append(reverse(array, i, --j));
                builder.append(" ");
                i = ++j;
            } else {
                j++;
            }
        }
        return builder.toString().trim();
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ReverseWordsInString instance = new ReverseWordsInString();
		String test1 = "Hello world!";
		System.out.println(instance.reverseWords2(test1));
	}

}
