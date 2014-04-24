package pointTo;

public class Question10NumberOf1 {
	
	public static int numberOf1(int n) {
		int count = 0;
		int flag = 1;
		while (flag > 0) {
			if ((n & flag) == 1) {
				count++;
			}
			flag = flag << 1;
		}
		return count;
	}
	
	public static int numberOf1Better(int n) {
		int count = 0;
		while (n != 0) {
			n = n&(n - 1);
			count++;
		}
		return count;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
