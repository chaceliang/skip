package edocteel.miscellaneous;

import java.util.ArrayList;

/**
 * Created by chace on 5/14/14.
 */
public class NQueen {
    public ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> results = new ArrayList<String[]>();

        if(n == 1) {
            results.add(new String[] {"Q"});
            return results;
        }

        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = i;
        }
        StringBuilder builder = new StringBuilder();
        while (getNext(A)) {
            if (isSafe(A)) {
                String[] board = new String[n];
                for (int i = 0; i < n; i++) {
                    builder.setLength(0);
                    for (int j = 0; j < n; j++) {
                        if (j == A[i]) {
                            builder.append("Q");
                        } else {
                            builder.append(".");
                        }
                    }
                    board[i] = builder.toString();
                }
                results.add(board);
            }
        }

        return results;
    }

    public boolean getNext(int[] A) {
        int length = A.length;
        for (int i = length - 2; i >= 0; i--) {
            if (A[i] < A[i+1]) {
                for (int j = length - 1; j > i; j--) {
                    if (A[j] > A[i]) {
                        swap(A, i, j);
                        int start = i+1, end = length - 1;
                        while (start <= end) {
                            swap(A, start, end);
                            start++; end--;
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public boolean isSafe(int[] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = i+1; j < A.length; j++) {
                if (A[i] == A[j] || Math.abs(i-j) == Math.abs(A[i] - A[j])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        NQueen test = new NQueen();
        test.solveNQueens(4);
    }
}
