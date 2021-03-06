package edocteel.miscellaneous;

/**
 * Created by chace on 5/13/14.
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        boolean isMinus = false;
        if (num1.length() >= 2 && num1.charAt(0) == '-') {
            isMinus = !isMinus;
            num1 = num1.substring(1);
        }
        if (num2.length() >= 2 && num2.charAt(0) == '-') {
            isMinus = !isMinus;
            num2 = num2.substring(1);
        }

        int[] result = new int[num1.length() + num2.length()];
        for (int i = 0; i < num1.length(); i++) {
            int carry = 0;
            int d1 = num1.charAt(num1.length() - 1 - i) - '0';
            for (int j = 0; j < num2.length(); j++) {
                int d2 = num2.charAt(num2.length() - 1 - j) - '0';
                carry = d1*d2 + result[i+j] + carry;
                result[i+j] = carry % 10;
                carry = carry / 10;
            }
            result[i + num2.length()] = carry;
        }
        StringBuilder sb = new StringBuilder();
        int zeroIndex = 0;
        for (int i = result.length - 1; i >= 0; i--) {
            if (result[i] == 0) {
                zeroIndex++;
            } else {
                break;
            }
        }
        for (int i = 0; i < result.length - zeroIndex; i++) {
            sb.insert(0, result[i]);
        }
        if (isMinus) {
            sb.insert(0, '-');
        }
        return sb.toString();
    }

    public String multiply2(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int l1 = num1.length(), l2 = num2.length();
        int[] n1 = new int[l1];
        int[] n2 = new int[l2];

        for (int i = 0; i < l1; i++) {
            n1[l1 - i - 1] = num1.charAt(i) - '0';
        }
        for (int i = 0; i < l2; i++) {
            n2[l2 - i - 1] = num2.charAt(i) - '0';
        }

        int sum = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < l1+l2-1; i++) {
            for (int j = 0; j <= i; j++) {
                if (j < l1 && i - j < l2) {
                    sum += n1[j] * n2[i-j];
                }
            }
            builder.append((char)(sum % 10 + '0'));
            sum /= 10;
        }
        if (sum > 0) {
            builder.append((char)(sum + '0'));
        }
        String s = builder.reverse().toString();
        return s.isEmpty() ? "0" : s;
    }
}
