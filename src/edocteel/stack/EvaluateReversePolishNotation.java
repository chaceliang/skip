package edocteel.stack;

import java.util.Stack;

/**
 * Created by chace on 5/12/14.
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length <= 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < tokens.length; i++) {
            if (isDigital(tokens[i])) {
                stack.push(Integer.parseInt(tokens[i]));
            } else {
                stack.push(cal(stack.pop(), stack.pop(), tokens[i]));
            }
        }
        return stack.pop();
    }

    public Integer cal(Integer num1, Integer num2, String op) {
        switch (op.charAt(0)) {
            case '+':
                return num2 + num1;
            case '-':
                return num2 - num1;
            case '*':
                return num2 * num1;
            case '/':
                return num2 / num1;
            default:
                return 0;
        }
    }

    public boolean isDigital(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
