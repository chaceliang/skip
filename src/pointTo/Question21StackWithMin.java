package pointTo;

import java.util.Stack;

public class Question21StackWithMin {

	public Stack<Integer> data;
	public Stack<Integer> min;
	
	public Question21StackWithMin() {
		this.data = new Stack<Integer>();
		this.min = new Stack<Integer>();
	}
	
	public void push(int v) {
		this.data.push(v);
		if (this.min.empty() || v <= this.min.peek()) {
			this.min.push(v);
		} else {
			this.min.push(this.min.peek());
		}
	}
	
	public int pop() {
		if (this.data.empty()) {
			return -1;
		}
		this.min.pop();
		return this.data.pop();
	}
	
	public int min() {
		if (this.min.empty()) {
			return -1;
		}
		return this.min.peek();
	}
	
	public boolean empty() {
		return this.data.empty();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Question21StackWithMin wierdStack = new Question21StackWithMin();
		wierdStack.push(5); wierdStack.push(6); wierdStack.push(2);
		wierdStack.push(1); wierdStack.push(9);
		while(!wierdStack.empty()) {
			System.out.println(wierdStack.min() + " " + wierdStack.pop());
		}
	}

}
