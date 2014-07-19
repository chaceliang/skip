package miscellaneous;

import java.util.Random;

/**
 * Created by chace on 5/25/14.
 */
public class ShuffleCards {
    public void shuffle() {
        int size = 52;
        int[] cards = new int[size];
        for (int i = 0; i < size; i++) {
            cards[i] = i;
        }
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            int r = rand.nextInt(size - i);
            int t = cards[r];
            cards[r] = cards[i];
            cards[i] = t;
        }

        for (int i = 0; i < size; i++) {
            System.out.print(cards[i] + 1);
            System.out.print(" ");
        }
    }

    public static void main(String[] args) {
        ShuffleCards test = new ShuffleCards();
        test.shuffle();
    }
}
