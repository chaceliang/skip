package company.linkedin;

import java.util.ArrayList;
import java.util.BitSet;

/**
 * Created by chace on 7/5/14.
 */
public class Influencer {
    BitSet set;

    static int USER = 0;
    static int INFLUNCER = 1;

    public Influencer() {
        set = new BitSet();
    }

    public int get(int userId) {
        return set.get(userId) ? INFLUNCER : USER;
    }

    public void set(int userId, int type) {
        set.set(userId, type == 0 ? false : true);
    }

    public ArrayList<Integer> getInfluncer() {
        ArrayList<Integer> result = new ArrayList<Integer>();
        BitSet map = new BitSet(set.size());
        map.set(0, set.size());
        map.and(set);
        for (int i = 0; i < set.size(); i++) {
            if (map.get(i)) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Influencer test = new Influencer();
        for (int i = 0; i < 100; i++) {
            test.set(i, i % 2 == 0 ? USER: INFLUNCER);
        }
        ArrayList<Integer> result = test.getInfluncer();
        for (Integer i : result) {
            System.out.println(i);
        }
    }
}
