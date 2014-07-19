package pointTo;

import java.util.HashMap;

public class Question26CopyLinkedListWithRandomPointer {

	public static ComplicateNode copyList(ComplicateNode head) {
		if (head == null) {
			return null;
		}
		
		ComplicateNode p = head;
		while (p != null) {
			ComplicateNode copy = new ComplicateNode(p.value);
			copy.next = p.next;
			p.next = copy;
			p = copy.next;
		}
		
		p = head;
		while (p != null && p.next != null) {
			if (p.random != null) {
				p.next.random = p.random;
			}
			p = p.next.next;
		}
		
		p = head;
		ComplicateNode newHead = head.next;
		while (p != null) {
			ComplicateNode temp = p.next;
			p.next = temp.next;
			if (temp.next != null) {
				temp.next = temp.next.next;
			}
			p = p.next;
		}
		return newHead;
	}
	
	public static ComplicateNode copyListWithMap(ComplicateNode head) {
		if (head == null) {
			return null;
		}
		HashMap<ComplicateNode, ComplicateNode> orig_copy = new HashMap<ComplicateNode, ComplicateNode>();
		ComplicateNode newHead = new ComplicateNode(head.value);
		
		ComplicateNode p = head;
		ComplicateNode q = newHead;
		orig_copy.put(head, newHead);
		p = p.next;
		
		while (p != null) {
			ComplicateNode copy = new ComplicateNode(p.value);
			orig_copy.put(p, copy);
			q.next = copy;
			q = copy;
			p = p.next;
		}
		
		p = head;
		q = newHead;
		while (p != null) {
			if (p.random != null) {
				q.random = orig_copy.get(p.random);
			} else {
				q.random = null;
			}
			p = p.next;
			q = q.next;
		}
		
		return newHead;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class ComplicateNode {
	int value;
	ComplicateNode next;
	ComplicateNode random;
	
	public ComplicateNode(int v) {
		this.value = v;
		next = null;
		random = null;
	}
}
