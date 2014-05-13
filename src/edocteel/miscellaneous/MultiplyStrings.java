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
}
