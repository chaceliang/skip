package edocteel.array;

/**
 * Created by chace on 5/4/14.
 */
public class RemoveDuplicateFromSortedArray {
    public int removeDuplicates(int[] A) {
        if (A.length <= 1) {
            return A.length;
        }
        int counter = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i-1] != A[i]) {
                A[counter] = A[i-1];
                counter++;
            }
        }
        A[counter++] = A[A.length - 1];
        return counter;
    }
}
