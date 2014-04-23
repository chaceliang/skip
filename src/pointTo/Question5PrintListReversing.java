package pointTo;

import java.util.Stack;

public class Question5PrintListReversing {
	
	public static void recursion(Node head) {
		if (head != null) {
			recursion(head.next);
			System.out.print(head.value + " ");
		}
	}

	public static void nonRecursion(Node head) {
		Stack<Node> stack = new Stack<Node>();
		while (head != null) {
			stack.push(head);
			head = head.next;
		}
		
		while (!stack.empty()) {
			Node n = stack.pop();
			System.out.print(n.value + " ");
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node head = new Node(5);
		head.next = new Node(4);
		head.next.next = new Node(3);
		
		nonRecursion(head);
	}

}
