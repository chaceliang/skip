package array;

/**
 * Created by Chace on 7/20/14.
 */
public class SumSmall {
    // Should have some better solutions. this is n2
    public static void twoSumSmall(int[] A, int N) {
        if (A == null) {
           throw new NullPointerException();
        }
        int len = A.length;
        int farest = len-1;
        for (int i = 0; i <= farest; i++) {
            for (int j = i+1; j <= farest; j++) {
                if (A[i] + A[j] <= N) {
                    System.out.println(A[i] + " + " + A[j] + " = " + (A[i] + A[j]));
                } else {
                    farest = j;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] A = {1,3,4,5,7,8,10};
        twoSumSmall(A, 8);
    }
}
