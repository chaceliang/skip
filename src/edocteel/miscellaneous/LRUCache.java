package edocteel.miscellaneous;

import java.util.AbstractMap;
import java.util.HashMap;

/**
 * Created by chace on 5/15/14.
 */
public class LRUCache {

    private Node head = null;
    private HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    private int capacity = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            detach(n);
            attach(n);
            return n.entry.getValue();
        } else {
            return -1;
        }
    }

    public void set(int key, int value) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            n.entry.setValue(value);
            detach(n);
            attach(n);
        } else {
            Node n = new Node();
            n.entry = new AbstractMap.SimpleEntry<Integer, Integer>(key, value);
            attach(n);
            map.put(key, n);
            if (map.size() > capacity) {
                Node last = head.prev;
                detach(last);
                map.remove(last.entry.getKey());
            }
        }
    }

    public void detach(Node n) {
        if (n == head) {
            head = n.next;
        }
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }

    public void attach(Node n) {
        if (head != null) {
            n.prev = head.prev;
            head.prev.next = n;
            n.next = head;
            head.prev = n;
            head = n;
        } else {
            head = n;
            head.next = n;
            head.prev = n;
        }
    }
}

class Node {
    Node prev;
    Node next;
    AbstractMap.SimpleEntry<Integer, Integer> entry;
}
