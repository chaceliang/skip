package edocteel.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {

    public ArrayList<Integer> findSubstring2(String S, String[] L) {
        ArrayList<Integer> results = new ArrayList<Integer>();
        if (S == null || S.length() <= 0 || L == null || L.length <= 0 || L[0].length() * L.length > S.length()) {
            return results;
        }

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < L.length; i++) {
            int count = 1;
            if (map.containsKey(L[i])) {
                count = map.get(L[i]) + 1;
            }
            map.put(L[i], count);
        }

        for (int i = 0; i < L[0].length(); i++) {
            HashMap<String, Integer> curMap = new HashMap<String, Integer>();
            int count = 0, left = i;
            for (int j = i; j < S.length() - L[0].length(); j+=L[0].length()) {
                String str = S.substring(j, j+L[0].length());
                if (map.containsKey(str)) {
                    if (curMap.containsKey(str)) {
                        curMap.put(str, curMap.get(str) + 1);
                    } else {
                        curMap.put(str, 1);
                    }
                    if (curMap.get(str) <= map.get(str)) {
                        count++;
                    } else {
                        while (curMap.get(str) > map.get(str)) {
                            String tmp = S.substring(left, left+L[0].length());
                            curMap.put(tmp, curMap.get(tmp) - 1);
                            if (curMap.get(tmp) < map.get(tmp)) {
                                count--;
                            }
                            left += L[0].length();
                        }
                    }
                    if (count == L.length) {
                        results.add(left);
                        String tmp = S.substring(left, left+L[0].length());
                        curMap.put(tmp, curMap.get(tmp) - 1);
                        count--;
                        left+=L[0].length();
                    }
                } else {
                    curMap.clear();
                    count = 0;
                    left = j + L[0].length();
                }
            }
        }

        return results;
    }

	public ArrayList<Integer> findSubstring(String S, String[] L) {
		if (S == null || S.length() <= 0 || L == null || L.length <= 0 || L[0].length() * L.length > S.length()) {
			return new ArrayList<Integer>();
		}
		ArrayList<Integer> result = new ArrayList<Integer>();
		HashMap<String, Integer> counter = new HashMap<String, Integer>();
		int length = L[0].length();
		for (String l : L) {
			if (counter.containsKey(l)) {
				counter.put(l, counter.get(l) + 1);
			} else {
				counter.put(l, 1);
			}
		}
		for (int i = 0; i <= S.length() - L.length * length; i++) {
			boolean found = true;
			HashMap<String, Integer> foundCounter = new HashMap<String, Integer>();
			for (int j = 0; j < L.length; j++) {
				int startIndex = i + j * length;
				String str = S.substring(startIndex, startIndex + length);
				if (!counter.containsKey(str)) {
					found = false;
					break;
				} else {
					if (!foundCounter.containsKey(str)) {
						foundCounter.put(str, 1);
					} else {
						foundCounter.put(str, foundCounter.get(str) + 1);
					}
					int count = counter.get(str);
					int foundCount = foundCounter.get(str);
					if (foundCount > count) {
						found = false;
						break;
					}
				}
			}
            for (Map.Entry<String, Integer> entry : counter.entrySet()) {
                if (!foundCounter.containsKey(entry.getKey())) {
                    found = false;
                    break;
                } else {
                    if (foundCounter.get(entry.getKey()) != entry.getValue()) {
                        found = false;
                        break;
                    }
                }
            }
			if (found) {
				result.add(i);
			}
		}
		return result;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
