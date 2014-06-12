package edocteel.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class ThreeSum {

    public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        if (num == null) {
            throw new NullPointerException();
        }
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();

        if (num.length < 3) {
            return results;
        }

        Arrays.sort(num);

        for (int i = 0; i < num.length; i++) {
            if (i > 0 && num[i-1] == num[i]) {
                continue;
            }
            int start = i + 1, end = num.length - 1;
            while (start < end) {
                int sum = num[i] + num[start] + num[end];
                if (sum < 0) {
                    start++;
                } else if (sum > 0) {
                    end--;
                } else {
                    ArrayList<Integer> result = new ArrayList<Integer>();
                    result.add(num[i]); result.add(num[start]); result.add(num[end]);
                    results.add(result);
                    do {
                        start++;
                    } while (start < end && num[start] == num[start - 1]);
                    do {
                        end--;
                    } while (start < end && num[end] == num[end + 1]);
                }
            }
        }

        return results;
    }

	public ArrayList<ArrayList<Integer>> threeSum1(int[] num) {
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
