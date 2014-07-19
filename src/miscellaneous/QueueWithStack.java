package miscellaneous;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Created by chace on 6/7/14.
 */
public class QueueWithStack {

    private Stack<Integer> in;
    private Stack<Integer> out;

    public QueueWithStack() {
        this.in = new Stack<Integer>();
        this.out = new Stack<Integer>();
    }

    public void offer(int v) {
        this.in.push(v);
    }

    public int pull() {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.pop();
    }

    public int peek() {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.peek();
    }

    public boolean isEmpty() {
        return in.isEmpty() || out.isEmpty();
    }

    public int size() {
        return in.size() + out.size();
    }
}
