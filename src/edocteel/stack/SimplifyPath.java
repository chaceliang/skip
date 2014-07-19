package edocteel.stack;

import java.util.Stack;

/**
 * Created by chace on 5/14/14.
 */
public class SimplifyPath {

    public String simplifyPath(String path) {
        if (path == null || path.length() <= 1) {
            return path;
        }
        Stack<String> stack = new Stack<String>();
        int slow = 0, fast = 0;
        int length = path.length();
        while (true) {
            while (slow < length && path.charAt(slow) == '/') {
                slow++;
            }
            if (slow >= length) {
                break;
            }
            fast = slow;
            while (fast < length && path.charAt(fast) != '/') {
                fast++;
            }
            String tmp = path.substring(slow, fast);
            if (tmp.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!tmp.equals(".")) {
                stack.push(tmp);
            }
            slow = fast;
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.insert(0, stack.pop());
            builder.insert(0, "/");
        }
        return builder.length() == 0 ? "/" : builder.toString();
    }
}
