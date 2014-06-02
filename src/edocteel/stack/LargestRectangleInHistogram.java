package edocteel.stack;

import java.util.Stack;

/**
 * Created by chace on 5/14/14.
 */
public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] height) {
        if (height == null || height.length <= 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        int maxArea = 0;
        while (i < height.length) {
            if (stack.isEmpty() || height[stack.peek()] <= height[i]) {
                stack.push(i++);
            } else {
                int t = stack.pop();
                int tmp = height[t] * (stack.isEmpty() ? i : i - stack.peek() - 1);
                maxArea = Math.max(maxArea, tmp);
            }
        }
        while (!stack.isEmpty()) {
            int t = stack.pop();
            int tmp = height[t] * (stack.isEmpty() ? i : i - stack.peek() - 1);
            maxArea = Math.max(maxArea, tmp);
        }
        return maxArea;
    }
}
