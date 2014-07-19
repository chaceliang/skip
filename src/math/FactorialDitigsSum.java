package math;

/**
 * Created by chace on 6/4/14.
 */
public class FactorialDitigsSum {

    public static int factorialDigitsSum(int n) {
        if (n <= 0) {
            return 0;
        }
        int top = 1;
        int[] num = new int[110];
        num[1] = 1;
        int carry = 0;
        for (int i = 2; i <= n; i++) {
            carry = 0;
            for (int j = 1; j <= top; j++) {
                int t = num[j]*i + carry;
                num[j] = t % 10;
                carry = t / 10;
                if (j == top && carry > 0) {
                    top++;
                }
            }
        }
        int sum = 0;
        for (int i = top; i >= 1; i--) {
            sum += num[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(factorialDigitsSum(5));
    }
}
