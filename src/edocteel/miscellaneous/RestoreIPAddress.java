package edocteel.miscellaneous;

import java.util.ArrayList;

/**
 * Created by chace on 5/13/14.
 */
public class RestoreIPAddress {

    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> ips = new ArrayList<String>();
        partitionIP(s, 0, 0, "", ips);
        return ips;
    }

    public void partitionIP(String s, int startIndex, int part, String result, ArrayList<String> ips) {
        // max 3 bits per partition
        if (s.length() - startIndex > (4 - part) * 3) {
            return;
        }
        // min 1 bit per partition
        if (s.length() - startIndex < (4 - part)) {
            return;
        }
        if (startIndex == s.length() && part == 4) {
            ips.add(new String(result.substring(0, result.length() - 1)));
            return;
        }
        int num = 0;
        for (int i = startIndex; i < startIndex + 3 && i < s.length(); i++) {
            num = num*10 + s.charAt(i) - '0';
            if (num <= 255) {
                result = result + s.charAt(i);
                partitionIP(s, i+1, part+1, result + '.', ips);
            }
            if (num == 0) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        RestoreIPAddress test = new RestoreIPAddress();
        test.restoreIpAddresses("1111");
    }
}
