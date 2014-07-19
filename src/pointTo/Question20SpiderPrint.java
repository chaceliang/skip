package pointTo;

public class Question20SpiderPrint {

	public static void spiderPrint(int[][] input) {
		if (input == null) {
			return;
		}
		int startX = 0, endX = input[0].length - 1;
		int startY = 0, endY = input.length - 1;
		
		while (startX <= endX && startY <= endY) {
			for (int i = startX; i<= endX; i++) {
				System.out.print(input[startY][i] + " ");
			}
			startY++;
			if (!shouldContinue(startX, endX, startY, endY)) {
				break;
			}
			for (int i = startY; i <= endY; i++) {
				System.out.print(input[i][endX] + " ");
			}
			endX--;
			if (!shouldContinue(startX, endX, startY, endY)) {
				break;
			}
			for (int i = endX; i >= startX; i--) {
				System.out.print(input[endY][i] + " ");
			}
			endY--;
			if (!shouldContinue(startX, endX, startY, endY)) {
				break;
			}
			for (int i = endY; i>= startY; i--) {
				System.out.print(input[i][startX] + " ");
			}
			startX++;
		}
		System.out.println();
	}
	
	public static boolean shouldContinue(int startX, int endX, int startY, int endY) {
		return startX <= endX && startY <= endY;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] input1 = {{1,2,3,4}, 
						  {5,6,7,8}, 
						  {9,10,11,12}, 
						  {13,14,15,16}, 
						  {17,18,19,20}};
		spiderPrint(input1);
		int[][] input2 = {{1,2,3,4}};
		spiderPrint(input2);
		int[][] input3 = {{1}, {2}, {3}, {4}};
		spiderPrint(input3);
	}

}
