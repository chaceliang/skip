package string;

import java.io.UnsupportedEncodingException;

/**
 * Created by chace on 6/6/14.
 */
public class ValidUTF8 {

    public static boolean isValid(String input) {
        byte[] bytes = null;
        try {
            bytes = input.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            return false;
        }
        return true;
    }
}
