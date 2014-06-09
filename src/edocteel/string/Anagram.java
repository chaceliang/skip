package edocteel.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class Anagram {

	public static ArrayList<String> anagrams(String[] strs) {
		ArrayList<String> result = new ArrayList<String>();
		
		HashMap<String, LinkedList<String>> counter = new HashMap<String, LinkedList<String>>();
		for (int i = 0; i < strs.length; i++) {
			String key = generateLabel(strs[i]);
			LinkedList<String> list = null;
			if (counter.get(key) == null) {
				list = new LinkedList<String>();
			} else {
				list = counter.get(key);
			}
			list.add(strs[i]);
			counter.put(key, list);
		}
		
		Iterator iter = counter.entrySet().iterator();
        while(iter.hasNext()) {
        	Map.Entry entry = (Map.Entry)iter.next();
        	LinkedList<String> set = (LinkedList<String>)entry.getValue();
        	if(set.size() > 1) {
        		Iterator it = set.iterator();
        		while(it.hasNext()) {
        			String w = (String)it.next();
        			result.add(w);
        		}
        	}
        }
        return result;
	}

    public boolean isAnagram(String a, String b) {
        if (a == null && b == null) {
            return true;
        } else if (a == null) {
            return false;
        } else if (b == null) {
            return false;
        }

        HashMap<Character, Integer> counter = new HashMap<Character, Integer>();
        for (int i = 0; i < a.length(); i++) {
            int count = 0;
            char c = a.charAt(i);
            if (counter.containsKey(c)) {
                count = counter.get(c);
            } else {
                count = 1;
            }
            counter.put(c, count);
        }

        for (int i = 0; i < b.length(); i++) {
            char c = b.charAt(i);
            if (!counter.containsKey(c)) {
                return false;
            } else {
                int count = counter.get(c);
                counter.put(c, count - 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : counter.entrySet()) {
            if (entry.getValue() > 0) {
                return false;
            }
        }
        return true;
    }

    public static String generateLabel(String str) {
        int[] hash = new int[26];
        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i) - 'a';
            hash[index]++;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (hash[i] > 0) {
                char c = (char)('a' + i);
                builder.append(c);
                builder.append(hash[i]);
            }
        }
        return builder.toString();
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
