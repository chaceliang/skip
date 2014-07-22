package array;

import java.util.ArrayList;
import java.util.Arrays;
import base.Utils;
/**
 * Created by Chace on 7/20/14.
 */
public class IncrementOne {

    public static void increment(ArrayList<Integer> A) {
        if (A == null) {
            throw new NullPointerException();
        }
        int carry = 1;
        int len = A.size();
        for (int i = len - 1; i >= 0 && carry > 0; i--) {
            int tmp = A.get(i) + carry;
            carry = tmp / 10;
            A.set(i, tmp % 10);
        }
        if (carry > 0) {
            A.add(0, carry);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(9,9,9,9,9,9,9,9,9));
        increment(A);
        for (int i : A) {
            Utils.print(i);
        }
    }
}
