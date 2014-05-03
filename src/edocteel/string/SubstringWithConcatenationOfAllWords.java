package edocteel.string;

import java.util.ArrayList;
import java.util.HashMap;

public class SubstringWithConcatenationOfAllWords {

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
