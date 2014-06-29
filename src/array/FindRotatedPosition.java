package array;

/**
 * Created by chace on 6/11/14.
 */
public class FindRotatedPosition {

    public static int findRotatedPosition1(int[] A) {
        if (A == null) {
            throw new NullPointerException();
        }
        int l = 0, r = A.length - 1;
        while (A[l] > A[r]) {
            int mid = (l + r)/2;
            if (A[mid] > A[r]) {
                l = mid+1;
            } else {
                r = mid;
            }
        }
        return A[l];
    }

    // No-duplicate
    public static int findRotatedPosition(int[] A) {
        if (A == null) {
            throw new NullPointerException();
        }
        int s = 0, e = A.length - 1;
        while (s < e) {
            if (e - s == 1) {
                return A[s] > A[e] ? A[e] : A[s];
            }
            int mid = (s + e) / 2;
            if (A[mid - 1] > A[mid] || A[mid] > A[mid + 1]) {
                if (A[mid - 1] > A[mid]) {
                    return A[mid];
                } else {
                    return A[mid + 1];
                }
            } else if (A[mid] < A[e]) {
                e = mid;
            } else {
                s = mid;
            }
        }
        return A[s];
    }

    public static void main(String[] args) {
        System.out.println(findRotatedPosition1(new int[] {1,2,3,4,5,5,6,7}));
        System.out.println(findRotatedPosition1(new int[] {4,4,4,5,6,6,7,7,7,1,1,1,1,2,3}));
        System.out.println(findRotatedPosition1(new int[] {1,2}));
        System.out.println(findRotatedPosition1(new int[] {2,1}));
        System.out.println(findRotatedPosition1(new int[] {2,3,1}));
        System.out.println(findRotatedPosition1(new int[] {1}));

    }
}
