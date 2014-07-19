package graph;

import java.util.*;

/**
 * Created by chace on 6/6/14.
 */
public class PrintTreeWithPairs {

    HashMap<String, String> child_parent;
    Hashtable<String, TNode> value_node;
    TNode root;
    public PrintTreeWithPairs(Set<Pair> input) {
        if (input == null) {
            throw new NullPointerException();
        }
        child_parent = new HashMap<String, String>();
        value_node = new Hashtable<String, TNode>();
        for (Pair pair : input) {
            TNode parent;
            if (value_node.containsKey(pair.parent)) {
                parent = value_node.get(pair.parent);
            } else {
                parent = new TNode(pair.parent);
            }
            TNode child;
            if (value_node.containsKey(pair.child)) {
                child = value_node.get(pair.child);
            } else {
                child = new TNode(pair.child);
            }
            parent.children.add(child);

            if (!child_parent.containsKey(parent.value)) {
                child_parent.put(parent.value, null);
            }
            if (child_parent.containsKey(child.value) && child_parent.get(child.value) != null) {
                if (child_parent.get(child.value) != parent.value) {
                    throw new NoSuchElementException();
                }
            } else {
                child_parent.put(child.value, parent.value);
            }
            value_node.put(parent.value, parent);
        }
    }

    public boolean isValid() {
        boolean hasValidRoot = false;
        for (String parent : this.child_parent.keySet()) {
            if (this.child_parent.get(parent) == null) {
                if (!hasValidRoot) {
                    this.root = value_node.get(parent);
                    hasValidRoot = !hasValidRoot;
                } else {
                    return false;
                }
            }
        }
        if (!hasValidRoot) {
            this.root = null;
        }
        return hasValidRoot;
    }

    public void print() {
        if (!isValid()) {
            return;
        }
        print(this.root, 0);
    }

    public void print(TNode x, int level) {
        for (int i = 0; i < level; i++) {
            System.out.print(" ");
        }
        System.out.println(x.value);
        List<TNode> children = x.children;
        if (children != null && children.size() > 0) {
            for (int i = 0; i < children.size(); i++) {
                print(children.get(i), level + 1);
            }
        }
    }

    public static void main(String[] args) {
        Set<Pair> pairs = new HashSet<Pair>();
        pairs.add(new Pair("a", "b"));
        pairs.add(new Pair("b", "c"));
        pairs.add(new Pair("a", "d"));
        pairs.add(new Pair("d", "e"));
        pairs.add(new Pair("d", "f"));
        pairs.add(new Pair("d", "g"));

        PrintTreeWithPairs test = new PrintTreeWithPairs(pairs);
        test.print();
    }
}

class Pair {
    String parent;
    String child;

    public Pair(String p, String c) {
        this.parent = p;
        this.child = c;
    }
}

class TNode {
    public String value;
    public List<TNode> children;

    public TNode(String v) {
        this.value = v;
        this.children = new ArrayList<TNode>();
    }
}