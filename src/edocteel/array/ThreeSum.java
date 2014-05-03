package edocteel.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class ThreeSum {

	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		if(num.length == 0) return results;
		
		HashSet set = new HashSet();
		
		Arrays.sort(num);
		
		for(int i = 0; i < num.length; i++) {
			int rest = 0-num[i];
			int start = i+1;
			int end = num.length-1;
			while(end > start) {
				if(num[start] + num[end] == rest) {
					ArrayList<Integer> result = new ArrayList<Integer>();
					result.add(num[i]);
					result.add(num[start]);
					result.add(num[end]);
					set.add(result);
					start++; end--;
				} else if(num[start] + num[end] < rest) {
					start++;
				} else if(num[start] + num[end] > rest) {
					end--;
				}
			}
		}
		
		Iterator it = set.iterator();
		while(it.hasNext()) {
			results.add((ArrayList<Integer>)it.next());
		}
		
		return results;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
