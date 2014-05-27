package array;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by chace on 5/26/14.
 */
public class GenerateRandomIndexOfMaxValue {

    public static int getIndex(int[] A) {
        if (A == null || A.length <= 0) {
            return -1;
        }

        int max = A[0];
        ArrayList<Integer> indexes = new ArrayList<Integer>();
        indexes.add(0);
        for (int i = 1; i < A.length; i++) {
            if (A[i] == max) {
                indexes.add(i);
            } else if (A[i] > max) {
                max = A[i];
                indexes = new ArrayList<Integer>();
                indexes.add(i);
            }
        }
        int n = indexes.size();
        Random rand = new Random();
        int index = rand.nextInt(n);
        return indexes.get(index);
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 6, 6, 6};
        for (int i = 0; i < 100; i++) {
            System.out.println(getIndex(A));
        }
    }
}
