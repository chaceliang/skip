package pointTo;

import java.util.Stack;

public class Question07QueueWith2Stack {
	
	Stack<Integer> stack1;
	Stack<Integer> stack2;
	
	public Question07QueueWith2Stack() {
		this.stack1 = new Stack<Integer>();
		this.stack2 = new Stack<Integer>();
	}
	
	public void push(int v) {
		this.stack1.push(v);
	}
	
	public int pop() {
		if (this.stack2.empty()) {
			while (!this.stack1.empty()) {
				this.stack2.push(this.stack1.pop());
			}
		}
		if (!this.stack2.empty()) {
			return this.stack2.pop();
		}
		return -1;
	}
	
	public boolean empty() {
		return this.stack1.empty() && this.stack2.empty();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Question07QueueWith2Stack test = new Question07QueueWith2Stack();
		test.push(1); test.push(2); test.push(3); test.push(4);
		while (!test.empty()) {
			System.out.print(test.pop() + " ");
		}
	}

}
