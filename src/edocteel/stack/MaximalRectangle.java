package edocteel.stack;

import java.util.Stack;

/**
 * Created by chace on 5/14/14.
 */
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = m == 0 ? 0 : matrix[0].length;
        int[][] height = new int[m][n];
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    height[i][j] = 0;
                } else {
                    height[i][j] = i == 0 ? 1 : height[i-1][j] + 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            int area = largestRectangleArea(height[i]);
            if (area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }

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
                maxArea = Math.max(maxArea, height[t] * (stack.isEmpty() ? i : i - stack.peek() - 1));
            }
        }
        while (!stack.isEmpty()) {
            int t = stack.pop();
            maxArea = Math.max(maxArea, height[t] * (stack.isEmpty() ? i : i - stack.peek() - 1));
        }
        return maxArea;
    }
}
