package pointTo;

import java.util.ArrayList;
import java.util.Arrays;

public class Question28Permutation {

	public void swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
	
	public boolean getNext(int[] array) {
		for(int i = array.length-2; i >= 0; i--) {
			if(array[i] < array[i+1]) {
				for(int j = array.length-1; j > i; j--) {
					if(array[j] > array[i]) {
						swap(array, i, j);
						int start = i+1;
						int end = array.length-1;
						while(start <= end) {
							swap(array, start, end);
							start++; end--;
						}
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public ArrayList<ArrayList<Integer>> permute(int[] num) {
		Arrays.sort(num);
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int i : num) result.add(i);
		results.add(result);
		while(getNext(num)) {
			result = new ArrayList<Integer>();
			for(int i : num) result.add(i);
			results.add(result);
		}
		return results;
	}
	
	/////////////////////////////////////////////
	public static void permutation(String str) { 
	    permutation("", str); 
	}

	private static void permutation(String prefix, String str) {
	    int n = str.length();
	    if (n == 0) System.out.println(prefix);
	    else {
	        for (int i = 0; i < n; i++)
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	    }
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
