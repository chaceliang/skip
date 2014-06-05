package array;

/**
 * Created by chace on 5/25/14.
 */
public class MinimumDistanceBetweenTwoNumbers {

    public static int minimumDistance(int[] A, int x, int y) {
        if (A == null || A.length <= 0) {
            return -1;
        }
        int prev = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == x || A[i] == y) {
                if (prev == -1) {
                    prev = i;
                } else {
                    if (A[prev] != A[i] && i - prev < min) {
                        min = i - prev;
                    }
                    prev = i;
                }
            }
        }
        return min;
    }

    public static int minDistance(String[] words, String word1, String word2) {
        if (words == null || words.length <= 0) {
            return -1;
        }
        int prev = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1) || words[i].equals(word2)) {
                if (prev == -1) {
                    prev = i;
                } else {
                    if (!words[prev].equals(words[i]) && min > i - prev) {
                        min = i - prev;
                    }
                    prev = i;
                }
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int arr[] ={3, 5, 4, 2, 6, 3, 0, 0, 5, 4, 8, 3};
        System.out.println(minimumDistance(arr, 3, 6));
    }
}
