package edocteel.array;

/**
 * Created by chace on 5/4/14.
 */
public class RemoveElement {
    /*
    Given an array and a value, remove all instances of that value in place and return the new length.
    The order of elements can be changed. It doesn't matter what you leave beyond the new length.
     */
    public int removeElement(int[] A, int elem) {
        if (A == null || A.length < 0) {
            return 0;
        }
        int counter = 0;
        int end = A.length - 1;
        while (counter <= end) {
            if (A[counter] == elem) {
                int tmp = A[counter];
                A[counter] = A[end];
                A[end] = tmp;
                end--;
            } else {
                counter++;
            }
        }
        return end+1;
    }
}
