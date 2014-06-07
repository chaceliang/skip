package juzzle;

/**
 * Created by chace on 6/7/14.
 */
public class Alphabet {

    public String alphabet;

    public static Alphabet LOWERCASE = new Alphabet("abcdefghijklmonpqrstuvwxyz") {
        private final int charOffset = Character.getNumericValue('a');

        public byte getIndex(char c) {
            return (byte)(Character.getNumericValue(c) - charOffset);
        }
    };

    public Alphabet(String alphabet) {
        this.alphabet = alphabet;
    }

    public byte[] toInt(String word) {
        byte[] r = new byte[word.length()];
        for (int i = 0; i < r.length; i++) {
            r[i] = getIndex(word.charAt(i));
        }
        return r;
    }

    public byte getIndex(char c) {
        return (byte)alphabet.indexOf(c);
    }

    public int size() {
        return alphabet.length();
    }
}
