package edocteel.miscellaneous;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by chace on 5/9/14.
 */
public class Permutations {

    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        results.add(arrayToList(num));
        while (getNextPermutation(num)) {
            results.add(arrayToList(num));
        }
        return results;
    }

    public ArrayList<Integer> arrayToList(int[] num) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < num.length; i++) {
            result.add(num[i]);
        }
        return result;
    }

    public boolean getNextPermutation(int[] num) {
        int length = num.length;
        for (int i = length - 2; i >= 0; i--) {
            if (num[i] < num[i+1]) {
                for (int j = length - 1; j > i; j--) {
                    if (num[j] > num[i]) {
                        swap(num, i, j);
                        int start = i + 1;
                        int end = length - 1;
                        while (start <= end) {
                            swap(num, start, end);
                            start++; end--;
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void swap(int[] num, int i, int j) {
        int tmp = num[j];
        num[j] = num[i];
        num[i] = tmp;
    }

    public static void main(String[] args) {
        Permutations test = new Permutations();
        test.permute(new int[]{1,2,3});
    }
}
