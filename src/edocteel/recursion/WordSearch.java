package edocteel.recursion;

/**
 * Created by chace on 5/6/14.
 */
public class WordSearch {

    public boolean exist(char[][] board, String word) {
        int N = board.length;
        int M = board[0].length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (bfs(i, j, board, word, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean bfs(int i, int j, char[][] board, String word, int p) {
        if (p == word.length()) {
            return true;
        }
        int N = board.length;
        int M = board[0].length;
        if (i >= 0 && i < N && j >= 0 && j < M && board[i][j] == word.charAt(p)) {
            char tmp = board[i][j];
            board[i][j] = '#';
            p++;
            if (bfs(i, j+1, board, word, p) || bfs(i+1, j, board, word, p) || bfs(i, j-1, board, word, p) || bfs(i-1, j, board, word, p)) {
                return true;
            }
            board[i][j] = tmp;
        }
        return false;
    }
}
