package miscellaneous;

import java.util.*;

/**
 * Created by chace on 6/7/14.
 */
public class RandomSetStructure {
    Map<Integer, Integer> map;
    List<Integer> array;
    Random random;

    public RandomSetStructure() {
        this.map = new HashMap<Integer, Integer>();
        this.array = new ArrayList<Integer>();
        random = new Random();
    }

    public void insert(int a) {
        if (map.containsKey(a)) {
            return;
        }
        array.add(a);
        map.put(a, array.size() - 1);
    }

    public void remove(int a) throws Exception {
        if (!map.containsKey(a)) {
            throw new RuntimeException();
        }
        int index = map.get(a);
        map.remove(a);
        array.set(index, array.get(array.size() - 1));
        map.put(array.get(index), index);
        array.remove(array.size() - 1);
    }

    public int getRandom() {
        if (map.isEmpty()) {
            throw new RuntimeException();
        }
        return array.get(random.nextInt(array.size()));
    }
}
