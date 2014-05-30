package miscellaneous;

/**
 * Created by chace on 5/28/14.
 */
public class Readline {

    static String buffer = "";

    public String read4k() {
        return "";
    }

    public String readLine() {
        if (!buffer.equals("")) {
            StringBuilder builder = new StringBuilder();
            int i = 0;
            while (buffer.charAt(i) != '\n' && i < buffer.length()) {
                builder.append(buffer.charAt(i));
                i++;
            }
            buffer = buffer.substring(i+1);
            if (i == builder.length()) {
                return builder.toString() + readLine();
            } else {
                return builder.toString();
            }
        } else {
            buffer = read4k();
            if (!buffer.equals("")) {
                return readLine();
            } else {
                return "";
            }
        }
    }
}