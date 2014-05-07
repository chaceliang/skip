package edocteel.miscellaneous;

import java.util.ArrayList;

/**
 * Created by chace on 5/7/14.
 */
public class PascalTriangleII {
    public static ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (rowIndex < 0) {
            return result;
        }
        int[] r = new int[rowIndex + 1];
        r[0] = 1;
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i; j > 0; j--) {
                r[j] = r[j] + r[j-1];
            }
        }
        for (int i = 0; i < r.length; i++) {
            if (r[i] != 0) {
                result.add(r[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        getRow(2);
    }
}
