package edocteel.array;

/**
 * Created by chace on 5/4/14.
 */
public class RemoveDuplicateFromSortedArray {
    /*
    Given an array and a value, remove all instances of that value in place and return the new length.
    It doesn't matter what you leave beyond the new length.
     */
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
