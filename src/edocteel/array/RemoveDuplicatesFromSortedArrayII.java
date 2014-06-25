package edocteel.array;

/**
 * Created by chace on 5/5/14.
 */
public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] A) {
        if (A == null) {
            return 0;
        }
        int length = A.length;
        if (length < 3) {
            return length;
        }
        int slow = 0, fast = 1, index = 0;
        while (fast < length) {
            while (fast < length && A[slow] == A[fast]) {
                fast++;
            }
            if (fast - slow <= 2) {
                while (slow < fast) {
                    A[index++] = A[slow++];
                }
            } else {
                A[index++] = A[slow++];
                A[index++] = A[slow++];
                slow = fast;
            }
            fast++;
        }
        while (slow < slow + 2 && slow < length) {
            A[index++] = A[slow++];
        }
        return index;
    }
}
