package string;

import java.util.Arrays;
import java.util.HashMap;

public class IsBSubstringOfA {

	// A couple of assumptions
	// 1. No duplicate
	// 2. All upper-case character
	
	public static boolean isSubstring1(String A, String B) {
		if (A == null || B == null || A.length() < B.length()) {
			return false;
		}
		
		int hash = 0;
		for (int i = 0; i < A.length(); i++) {
			hash |= (1 << A.charAt(i) - 'A');
		}
		
		for (int i = 0; i < B.length(); i++) {
			if ((hash & (1 << (B.charAt(i) - 'A'))) == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isSubstring2(String A, String B) {
		if (A == null || B == null || A.length() < B.length()) {
			return false;
		}
		HashMap<Character, Integer> counter = new HashMap<Character, Integer>();
		for (int i = 0; i < A.length(); i++) {
			char t = A.charAt(i);
			int count = 0;
			if (counter.get(t) != null) {
				count = counter.get(t);
			}
			counter.put(t, count+1);
		}
		for (int i = 0; i < B.length(); i++) {
			char t = B.charAt(i);
			if (counter.get(t) == null) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isSubstring3(String A, String B) {
		if (A == null || B == null || A.length() < B.length()) {
			return false;
		}
		char[] AA = A.toCharArray();
		char[] BB = B.toCharArray();
		Arrays.sort(AA);
		Arrays.sort(BB);
		int ai = 0, bi = 0;
		while (ai < A.length() && bi < B.length()) {
			if (AA[ai] == BB[bi]) {
				ai++;
				bi++;
			} else if (AA[ai] > BB[bi]) {
				return false;
			} else {
				ai++;
			}
		}
		if (bi != B.length()) {
			return false;
		}
		return true;
	}
	
	//Overflow
	public static boolean isSubstring4(String A, String B) {
		int[] p = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59,61, 67, 71, 73, 79, 83, 89, 97, 101};
		long result = 1;
		for (int i = 0; i < A.length(); i++) {
			int x = p[A.charAt(i) - 'A'];
			if (result % x > 0) {
				result *= x;
			}
		}
		for (int i = 0; i < B.length(); i++) {
			int x = p[B.charAt(i) - 'A'];
			if (result % x > 0) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String A = "ABCDEFGHLMNOPQRS";
		String B = "DCGSRQPO";
		System.out.println(isSubstring1(A, B));
		System.out.println(isSubstring2(A, B));
		System.out.println(isSubstring3(A, B));
		System.out.println(isSubstring4(A, B));
		
		String C = "ABCDEFGHLMNOPQRS";
		String D = "DCGSRQPZ";
		System.out.println(isSubstring1(C, D));
		System.out.println(isSubstring2(C, D));
		System.out.println(isSubstring3(C, D));
		System.out.println(isSubstring4(C, D));
	}

}
