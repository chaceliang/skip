package array;

import java.util.ArrayList;

/**
 * Created by chace on 5/23/14.
 */
public class PrintDiagonal {

    public static ArrayList<ArrayList<Character>> print(char[][] A) {
        ArrayList<ArrayList<Character>> results = new ArrayList<ArrayList<Character>>();
        if (A == null || A.length <= 0) {
            return results;
        }
        int len = A.length;
        ArrayList<Character> result = new ArrayList<Character>();
        for (int i = 0; i < len; i++) {
            result.add(A[i][i]);
        }
        results.add(new ArrayList<Character>(result));

        for (int i = 1; i < len; i++) {
            result = new ArrayList<Character>();
            for (int j = 0; j+i < len; j++) {
                result.add(A[j][j+i]);
            }
            results.add(new ArrayList<Character>(result));
        }

        for (int i = 1; i < len; i++) {
            result = new ArrayList<Character>();
            for (int j = 0; j+i < len; j++) {
                result.add(A[j+i][j]);
            }
            results.add(new ArrayList<Character>(result));
        }

        return results;
    }

    public static void main(String[] args) {
        char[][] A = {{'a', 'b', 'c', 'd'},
                      {'e', 'f', 'g', 'h'},
                      {'i', 'j', 'k', 'l'},
                      {'m', 'n', 'o', 'p'}};
        ArrayList<ArrayList<Character>> results = print(A);
        for (ArrayList<Character> result : results) {
            for (Character c : result) {
                System.out.print(c);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
