package edocteel.miscellaneous;

import java.util.Arrays;

/**
 * Created by chace on 5/9/14.
 */
public class NextPermutation {
    public void nextPermutation(int[] num) {
        if (!getNextPermutation(num)) {
            Arrays.sort(num);
        }
    }

    public boolean getNextPermutation(int[] num) {
        for (int i = num.length - 2; i >= 0; i--) {
            if (num[i] < num[i+1]) {
                for (int j = num.length - 1; j > i; j--) {
                    if (num[j] > num[i]) {
                        swap(num, i, j);
                        int start = i + 1;
                        int end = num.length - 1;
                        while (start <= end) {
                            swap(num, start, end);
                            start++;
                            end--;
                        }
                        return true;
                    }
                }

            }
        }
        return false;
    }

    public void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
