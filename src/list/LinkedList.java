package list;

/**
 * Created by chace on 6/4/14.
 */
public class LinkedList {
    private Node head;

    public LinkedList() {
        this.head = null;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    // Insert the new node at the beginning of list
    public void insertHead(int data) {
        Node newNode = new Node(data);
        newNode.next = this.head;
        this.head = newNode;
    }

    public void insertTail(int data) {
        Node newNode = new Node(data);
        Node current = this.head;
        if (current == null) {
            this.head = newNode;
        }
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public Node deleteHead() {
        Node tmp = this.head;
        this.head = this.head.next;
        return tmp;
    }

    public Node delete(Node toDelete) {
        Node current = this.head;
        if (current == null) {
            return null;
        }
        if (current == toDelete) {
            this.head = current.next;
            return current;
        }

        while (current.next != toDelete && current.next != null) {
            current = current.next;
        }
        if (current.next == null) {
            return null;
        }
        current.next = current.next.next;
        return toDelete;
    }
}

class Node {
    public int data;
    public Node next;

    public Node(int d) {
        this.data = d;
        this.next = null;
    }
}