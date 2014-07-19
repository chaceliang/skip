package array;

/**
 * Created by chace on 6/4/14.
 */
public class CountAppearTimesOfDuplicate {

    // A is sorted
    public static int findAppearTimesOfDuplicate(int[] A, int dup) {
        if (A == null || A.length <= 0 || dup < A[0] || dup > A[A.length - 1]) {
            return 0;
        }
        int len = A.length;
        int start = 0, end = len - 1;
        int begin = 0, last = 0;

        // Find start of dup
        while (start <= end) {
            int mid = (start + end) / 2;
            if (A[mid] < dup) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        begin = end + 1;

        start = 0; end = len - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (A[mid] > dup) {
                end = start - 1;
            } else {
                start = mid + 1;
            }
        }
        last = start - 1;
        return last - begin + 1;
    }

    public static void main(String[] args) {
        System.out.println(findAppearTimesOfDuplicate(new int[]{1,2,2,2,3,4,5}, 2));
        System.out.println(findAppearTimesOfDuplicate(new int[]{2,2,2,2,3,4,5}, 2));
        System.out.println(findAppearTimesOfDuplicate(new int[]{2,2,2,2,2,2,2}, 2));
        System.out.println(findAppearTimesOfDuplicate(new int[]{2,2,2,2,3,4,5}, 6));
    }
}
