package pointTo;

import java.util.Stack;

public class Question22IsStackPopOrder {

	public static boolean isPopOrder(int[] push, int[] pop) {
		boolean isPossible = false;
		if (push != null && pop != null && push.length == pop.length) {
			int length = push.length;
			int pushIndex = 0;
			int popIndex = 0;
			Stack<Integer> temp = new Stack<Integer>();
			while (popIndex < length) {
				while (temp.empty() || temp.peek() != pop[popIndex]) {
					if (pushIndex >= length) {
						break;
					}
					temp.push(push[pushIndex++]);
				}
				if (temp.peek() != pop[popIndex]) {
					break;
				}
				temp.pop();
				popIndex++;
			}
			if (temp.empty() && popIndex >= length && pushIndex >= length) {
				isPossible = true;
			}
		}
		
		return isPossible;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] push = {1,2,3,4,5};
		int[] pop1 = {4,5,3,2,1};
		int[] pop2 = {4,3,5,1,2};
		System.out.println(isPopOrder(push, pop1));
		System.out.println(isPopOrder(push, pop2));
	}

}
