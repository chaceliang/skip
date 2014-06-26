package graph;

import java.util.Stack;

/**
 * Created by chace on 6/25/14.
 */
public class GroupOf1 {

    public void flipAdjancent1(int[][] nums, int i, int j) {
        Stack<IndexPair> stack = new Stack<IndexPair>();
        stack.push(new IndexPair(i, j));
        while (!stack.isEmpty()) {
            IndexPair curr = stack.pop();

            nums[curr.x][curr.y] = 0;
            if (curr.x - 1 >= 0 && nums[curr.x-1][curr.y] == 1) {
                stack.push(new IndexPair(curr.x - 1, curr.y));
            }
            if (curr.y - 1 >= 0 && nums[curr.x][curr.y - 1] == 1) {
                stack.push(new IndexPair(curr.x, curr.y - 1));
            }
            if (curr.x + 1 < nums.length && nums[curr.x + 1][curr.y] == 1) {
                stack.push(new IndexPair(curr.x + 1, curr.y));
            }
            if (curr.y + 1 < nums.length && nums[curr.x][curr.y + 1] == 1) {
                stack.push(new IndexPair(curr.x + 1, curr.y));
            }
        }
    }

    public int groupOf1(int[][] nums) {
        if (nums == null) {
            throw new NullPointerException();
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                if (nums[i][j] == 1) {
                    count++;
                    flipAdjancent1(nums, i, j);
                }
            }
        }
        return count;
    }
}

class IndexPair {
    int x, y;
    public IndexPair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}