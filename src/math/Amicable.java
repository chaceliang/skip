package math;

import java.util.Hashtable;

/**
 * Created by chace on 6/17/14.
 */
public class Amicable {
    /*the smallest pair of amicable numbers is (220, 284);
    for the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110,
    of which the sum is 284; and the proper divisors of 284 are 1, 2, 4, 71 and 142,
    of which the sum is 220.
     */

    public static int sumFactors(int n) {
        int sum = 0;
        for (int div = 1; div <= n/2; div++) {
            if (n % div == 0) {
                sum += div;
            }
        }
        return sum;
    }

    public static int[][] getMatrix(int limit) {
        int[] A = new int[limit];
        for (int i = 2; i < limit; i++) {
            A[i] = sumFactors(i);
        }
        Hashtable<Integer, Integer> map = new Hashtable<Integer, Integer>();
        for (int i = 2; i < limit; i++) {
            int j = A[i];
            if (j < i && i == A[j]) {
                map.put(i, j);
            }
        }
        int[][] matrix = new int[map.size()][2];
        int index = 0;
        for (int key : map.keySet()) {
            matrix[index][0] = key;
            matrix[index][1] = map.get(key);
            index++;
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = getMatrix(10000);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(matrix[i][0] + " " + matrix[i][1]);
        }
    }
}
