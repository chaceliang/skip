package miscellaneous;

import java.util.Stack;

/**
 * Created by chace on 7/2/14.
 */
public class CelebrityProblem {

    static int N = 8;
    static int size = 4;
    static int matrix[][] = {{0,0,1,0},
                            {0,0,1,0},
                            {0,0,0,0},
                            {0,0,1,0}};

    public static boolean haveAcquiantance(int a, int b) {
        return matrix[a][b] != 0;
    }

    public static int celebrityUsingStack(int size) {
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        while (i < size) {
            stack.push(i++);
        }
        int A = stack.pop();
        int B = stack.pop();

        while (stack.size() != 1) {
            if (haveAcquiantance(A, B)) { // A knows B
                A = stack.pop();
            } else {
                B = stack.pop();
            }
        }

        int C = stack.pop();
        if (haveAcquiantance(C, B)) {
            C = B;
        }
        if (haveAcquiantance(C, A)) {
            C = A;
        }
        return C;
    }

    public static int saintyTest(int C) {
        int i = 0;
        Stack<Integer> stack = new Stack<Integer>();
        while (i < size) {
            if (i != C) {
                stack.push(i);
            }
            i++;
        }
        while (!stack.isEmpty()) {
            i = stack.pop();
            if (haveAcquiantance(C, i)) {
                return -1;
            }
            if (!haveAcquiantance(i, C)) {
                return -1;
            }
        }
        return C;
    }
}
