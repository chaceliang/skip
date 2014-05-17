package edocteel.recursion;

import java.util.*;

/**
 * Created by chace on 5/16/14.
 */
public class WordLadder {

    public int ladderLength(String start, String end, HashSet<String> dict) {
        Queue<String> q = new LinkedList<String>();
        Map<String, Integer> ladderMap = new HashMap<String, Integer>();
        q.offer(start);
        ladderMap.put(start, 1);
        while (!q.isEmpty()) {
            String curr = q.poll();
            int dist = ladderMap.get(curr) + 1;
            for (int i = 0; i < curr.length(); i++) {
                StringBuilder builder = new StringBuilder(curr);
                for (char c = 'a'; c <= 'z'; c++) {
                    builder.setCharAt(i, c);
                    String next = builder.toString();
                    if (next.equals(end)) {
                        return dist;
                    }
                    if (dict.contains(next)) {
                        ladderMap.put(next, dist);
                        q.offer(next);
                        dict.remove(next);
                        if (dict.isEmpty()) {
                            break;
                        }
                    }
                }
            }
        }
        return 0;
    }

}
