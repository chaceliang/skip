package edocteel.stack;

import java.util.Stack;

/**
 * Created by chace on 5/8/14.
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }
        int length = s.length();
        int sum = 0;
        int currentLen = 0;
        int maxLen = 0;
        Stack<Integer> stack = new Stack<Integer>();
        boolean[] record = new boolean[length];
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == '(') {
                sum++;
                stack.push(i);
            } else if (sum > 0) {
                sum--;
                int index = stack.pop();
                record[index] = true;
                record[i] = true;
            }
        }
        for (int i = 0; i < length; i++) {
            if (record[i]) {
                currentLen++;
            } else {
                maxLen = Math.max(maxLen, currentLen);
                currentLen = 0;
            }
        }
        maxLen = Math.max(maxLen, currentLen);
        return maxLen;
    }
}
