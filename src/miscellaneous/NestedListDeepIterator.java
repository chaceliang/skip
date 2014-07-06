package miscellaneous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;

/**
 * Created by chace on 7/5/14.
 */
public class NestedListDeepIterator<T> implements Iterator<T> {

    public Stack<ArrayPosition> stack;

    public NestedListDeepIterator(ArrayList list) {
        stack = new Stack<ArrayPosition>();
        stack.push(new ArrayPosition(list));
    }

    @Override
    public boolean hasNext() {
        if (stack.isEmpty()) {
            return false;
        }
        ArrayPosition top = stack.peek();
        if (top.array.size() <= top.index) {
            stack.pop();
            return hasNext();
        }
        if (top.peekItem() instanceof ArrayList) {
            stack.push(new ArrayPosition((ArrayList)top.takeItem()));
            return hasNext();
        }
        return true;
    }

    @Override
    public T next() {
        ArrayPosition top = stack.peek();
        return (T)top.takeItem();
    }

    @Override
    public void remove() {
        ArrayPosition top = stack.peek();
        top.array.remove(--top.index);
    }

    public static void main(String[] args) {
        ArrayList al = new ArrayList(Arrays.asList(new Integer[]{1,2,3}));
        al.add(new ArrayList(Arrays.asList(new Integer[]{4, 5})));
        al.add(new ArrayList());
        NestedListDeepIterator di = new NestedListDeepIterator<Integer>(al);
        while (di.hasNext()) {
            int m = (Integer) di.next();
            System.out.println(m);
        }
//        di = new ListDeepIterator<Integer>(al);
//        while (di.hasNext()) {
//            int m = (Integer) di.next();
//            System.out.println(m);
//        }
    }
}

class ArrayPosition {
    ArrayList array;
    int index;

    public ArrayPosition(ArrayList array) {
        this.array = array;
        index = 0;
    }

    Object peekItem() {
        return array.get(index);
    }

    Object takeItem() {
        return array.get(index++);
    }
}