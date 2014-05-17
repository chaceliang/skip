package edocteel.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by chace on 5/17/14.
 */
public class SurroundedRegions {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        Queue<Pair> queue = new LinkedList<Pair>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (i == 0 || i == (board.length - 1) || j == 0 || j == (board[0].length - 1)) {
                    if (board[i][j] == 'O') {
                        Pair position = new Pair(i, j);
                        queue.offer(position);
                    }
                }
            }
        }

        int x1, y1;

        while (!queue.isEmpty()) {
            Pair position = (Pair) queue.poll();
            x1 = position.x;
            y1 = position.y;

            if (board[x1][y1] == 'Y') {
                continue;
            }

            board[x1][y1] = 'Y';
            // up
            int index = x1 - 1;
            if (index >= 0 && board[index][y1] == 'O') {
                queue.add(new Pair(index, y1));
            }

            // Left
            index = y1 - 1;
            if (index >= 0 && board[x1][index] == 'O') {
                queue.add(new Pair(x1, index));
            }

            // Down
            index = x1 + 1;
            if (index < board.length && board[index][y1] == 'O') {
                queue.add(new Pair(index, y1));
            }

            // Right
            index = y1 + 1;
            if (index < board[0].length && board[x1][index] == 'O') {
                queue.add(new Pair(x1, index));
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'Y') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(int x, int y, char[][] board) {
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] != 'O') {
            return;
        }
        board[x][y] = 'Y';
        dfs(x-1, y, board);
        dfs(x+1, y, board);
        dfs(x, y-1, board);
        dfs(x, y+1, board);
    }

    public void solve2(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            dfs(i, 0, board);
            dfs(i, n-1, board);
        }

        for (int i = 1; i < n-1; i++) {
            dfs(0, i, board);
            dfs(m-1, i, board);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'Y') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }
}

class Pair {
    int x;
    int y;
    Pair(int x,int y) {
        this.x = x;
        this.y = y;
    }
}