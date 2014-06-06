package graph;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by chace on 6/6/14.
 */
public class FindPathForGivenWord {

    static char[][] map = new char[][] {
            {'a', 'b', 'c', 'd', 'e'},
            {'f', 'g', 'h', 'i', 'j'},
            {'k', 'l', 'm', 'n', 'o'},
            {'p', 'q', 'r', 's', 't'},
            {'u', 'v', 'w', 'x', 'y'},
            {'z', '=', '=', '=', '='}
    };

    public static ArrayList<String> findPath(String word) {
        ArrayList<String> result = new ArrayList<String>();
        findPath(result, word.toLowerCase(), 0, 0, 0);
        return result;
    }

    public static boolean findPath(ArrayList<String> result, String word, int index, int i, int j) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i >= map.length || j < 0 || j >= map[0].length || map[i][j] == '*' || map[i][j] == '=') {
            return false;
        }
        char tmp = map[i][j];
        map[i][j] = '*';
        if (tmp == word.charAt(index)) {
            result.add("OK");
            index += 1;
            if (index == word.length()) {
                return true;
            }
        }
        result.add("UP");
        if (findPath(result, word, index, i-1, j)) {
            return true;
        }
        result.remove(result.size() - 1);
        result.add("RIGHT");
        if (findPath(result, word, index, i, j+1)) {
            return true;
        }
        result.remove(result.size() - 1);
        result.add("DOWN");
        if (findPath(result, word, index, i+1, j)) {
            return true;
        }
        result.remove(result.size() - 1);
        result.add("LEFT");
        if (findPath(result, word, index, i, j-1)) {
            return true;
        }
        result.remove(result.size() - 1);
        map[i][j] = tmp;
        return false;
    }

    public static void main(String[] args) {
        ArrayList<String> result = findPath("con");
        for (String str : result) {
            System.out.println(str);
        }
    }
}
