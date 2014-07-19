package company.amazon;

import java.util.*;

/**
 * Created by chace on 6/26/14.
 */
public class FirstNonRepeatCharacterInStream {

    public static char firstNonRepeat(Stream stream) {
        Hashtable<Character, Integer> counter = new Hashtable<Character, Integer>();
        Queue<Character> queue = new LinkedList<Character>();
        while (stream.hasNext()) {
            char tmp = stream.getNext();
            if (!counter.containsKey(tmp)) {
                counter.put(tmp, 1);
                queue.offer(tmp);
            } else {
                counter.put(tmp, counter.get(tmp) + 1);
            }
        }
        while (!queue.isEmpty()) {
            char tmp = queue.poll();
            if (counter.get(tmp) == 1) {
                return tmp;
            }
        }
        return '\u0000';
    }

    public static void main(String[] args) {
        Stream stream = new Stream("aAbBABac");
        System.out.println(firstNonRepeat(stream));
    }
}

class Stream {
    String buffer;
    Queue<Character> queue;

    public Stream(String b) {
        this.buffer = b;
        this.queue = new LinkedList<Character>();
        for (char c : buffer.toCharArray()) {
            this.queue.offer(c);
        }
    }
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    public char getNext() {
        if (!hasNext()) {
            throw new NullPointerException();
        }
        return queue.poll();
    }
}

class Components {
    char val;
    int index;
    int counter;

    public Components(char v, int index) {
        this.val = v;
        this.index = index;
        this.counter = 1;
    }
}

class ComponentsComparator implements Comparator<Components> {

    @Override
    public int compare(Components components1, Components components2) {
        if (components1.counter == 1 && components2.counter == 1) {
            return components1.index - components2.index;
        } else if (components1.counter == 1) {
            return 1;
        } else {
            return -1;
        }
    }
}