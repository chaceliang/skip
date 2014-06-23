package miscellaneous;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by chace on 6/22/14.
 */
public class NestedList<Object> implements Iterable<Object> {

    List<Object> cache;
    public NestedList(List<Object> input) {
        cache = input;
    }

    public Iterator<Object> iterator() {
        Iterator<Object> it = new Iterator<Object>() {
            int pos = 0;
            LinkedList<Object> data = (LinkedList<Object>) cache;

            @Override
            public boolean hasNext() {
                return pos != data.size();
            }

            @Override
            public Object next() {
                if (!hasNext()) {
                    return null;
                }
                Object o = data.get(pos);
                if (o instanceof Integer) {
                    pos++;
                    return o;
                } else {
                    LinkedList<Object> t = (LinkedList<Object>) o;
                    data.remove(pos);
                    for (int i = t.size() - 1; i >= 0; i--) {
                        data.add(pos, t.get(i));
                    }
                    return data.get(pos++);
                }
            }

            @Override
            public void remove() {

            }
        };
        return it;
    }
}
