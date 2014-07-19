package miscellaneous;

import java.util.*;

/**
 * Created by chace on 7/5/14.
 */
public class NestedMapDeepIterator<T> implements Iterator<T> {

    Stack<Position> stack;

    public NestedMapDeepIterator(Map<String, Object> map) {
        stack = new Stack<Position>();
        stack.push(new Position(map));
    }

    @Override
    public boolean hasNext() {
        if (stack.isEmpty()) {
            return false;
        }
        Position top = stack.peek();
        if (top.index >= top.keys.length) {
            stack.pop();
            return hasNext();
        }

        if (top.peekItem() instanceof Map) {
            stack.push(new Position((Map)top.popItem()));
            return hasNext();
        }
        return true;
    }

    @Override
    public T next() {
        Position top = stack.peek();
        return (T)top.popItem();
    }

    @Override
    public void remove() {

    }

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("aaa", "AAA");
        map.put("bbb", "BBB");
        map.put("ccc", "CCC");
        Map<String, Object> subMap = new HashMap<String, Object>();
        subMap.put("ddd", "DDD");
        subMap.put("eee", "EEE");
        map.put("subMap", subMap);

        NestedMapDeepIterator it = new NestedMapDeepIterator(map);
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}

class Position {
    String[] keys;
    Map<String, Object> map;
    int index;

    public Position(Map<String, Object> m) {
        map = m;
        index = 0;
        keys = map.keySet().toArray(new String[map.keySet().size()]);
    }

    public Object peekItem() {
        return map.get(keys[index]);
    }

    public Object popItem() {
        return map.get(keys[index++]);
    }
}
