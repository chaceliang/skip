package edocteel.miscellaneous;

/**
 * Created by chace on 5/9/14.
 */
public class PermutationSequence {
    public String getPermutation(int n, int k) {
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = i+1;
        }
        while (--k > 0) {
            getNextPermutation(num);
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            builder.append(num[i]);
        }
        return builder.toString();
    }

    public boolean getNextPermutation(int[] num) {
        int length = num.length;
        for (int i = length - 2; i >= 0; i--) {
            if (num[i] < num[i+1]) {
                for (int j = length - 1; j > i; j--) {
                    if (num[j] > num[i]) {
                        swap(num, i, j);
                        int start = i+1;
                        int end = length-1;
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
