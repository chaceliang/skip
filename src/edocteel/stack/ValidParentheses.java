package edocteel.stack;

import java.util.Stack;

/**
 * Created by chace on 5/5/14.
 */
public class ValidParentheses {

    public static boolean isValid(String s) {
        if (s == null || s.length() <= 0) {
            return true;
        }
        Stack<Character> parenthesesStack = new Stack<Character>();
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i++);
            if (c == '(' || c == '{' || c == '[') {
                parenthesesStack.push(c);
            } else {
                if (parenthesesStack.isEmpty()) {
                    return false;
                }
                char p = parenthesesStack.pop();
                if (p == '(' && c != ')') {
                    return false;
                } else if (p == '{' && c != '}') {
                    return false;
                } else if (p == '[' && c != ']') {
                    return false;
                }
            }
        }
        return parenthesesStack.isEmpty();
    }

    public static void main(String[] args) {
        isValid("()[]{}");
    }
}
