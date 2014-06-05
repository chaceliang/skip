package miscellaneous;

import java.util.HashMap;

/**
 * Created by chace on 6/4/14.
 */
public class IterateHashMap {

    public static void iterate(HashMap<String, Object> map, int level) {
        if (map == null) {
            return;
        }
        for (String key : map.keySet()) {
            Object value = map.get(key);
            if (value instanceof HashMap) {
                iterate((HashMap<String, Object>) value, level + 1);
            } else {
                for (int i = 0; i < level; i++) {
                    System.out.print(" ");
                }
                System.out.println("Key: " + key + " value: " + value);
            }
        }
    }
}
