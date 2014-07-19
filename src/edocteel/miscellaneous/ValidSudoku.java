package edocteel.miscellaneous;

import java.util.HashSet;

/**
 * Created by chace on 5/22/14.
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        if (board == null) {
            return false;
        }
        for (int i = 0; i < board[0].length; i++) {
            HashSet<Character> cache = new HashSet<Character>();
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] != '.' && !cache.add(board[j][i])) {
                    return false;
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            HashSet<Character> cache = new HashSet<Character>();
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.' && !cache.add(board[i][j])) {
                    return false;
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                HashSet<Character> cache = new HashSet<Character>();
                for (int m = i * 3; m < i * 3 + 3; m++) {
                    for (int n = j * 3; n < j * 3 + 3; n++) {
                        if (board[m][n] != '.' && !cache.add(board[m][n])) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}
