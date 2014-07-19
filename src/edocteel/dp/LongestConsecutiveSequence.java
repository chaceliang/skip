package edocteel.dp;

import java.util.*;

/**
 * Created by chace on 5/7/14.
 */
public class LongestConsecutiveSequence {

    private int findConsecutive(HashSet<Integer> set, int num, int step) {
        int len = 0;
        while (set.contains(num)) {
            len++;
            set.remove(num);
            num += step;
        }
        return len;
    }

    public int longestConsecutiveFaster(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i : nums) {
            set.add(i);
        }
        int maxLen = 0;
        for (int i : nums) {
            if (set.contains(i)) {
                set.remove(i);
                int len = 1 + findConsecutive(set, i-1, -1);
                len += findConsecutive(set, i+1, 1);
                if (len > maxLen) {
                    maxLen = len;
                }
            }
        }
        return maxLen;
    }

    public int longestConsecutive1(int[] num) {
        if (num == null || num.length <= 0) {
            return 0;
        }
        Arrays.sort(num);
        int currentLen = 0;
        int prev = 0;
        int maxLen = 0;
        for (int i = 0; i < num.length; i++) {
            if (i == 0) {
                currentLen++;
            } else if (prev == num[i]) {
                continue;
            } else if (num[i] - prev == 1) {
                currentLen++;
            } else {
                if (currentLen > maxLen) {
                    maxLen = currentLen;
                }
                currentLen = 1;
            }
            prev = num[i];
        }
        if (currentLen > maxLen) {
            maxLen = currentLen;
        }
        return maxLen;
    }

    public int longestConsecutive(int[] num) {
        if (num == null || num.length <= 0) {
            return 0;
        }
        Set<Integer> nums = new HashSet<Integer>();
        for (int i = 0; i < num.length; i++) {
            nums.add(num[i]);
        }
        int maxLen = 0;
        for (int i = 0; i < num.length; i++) {
            if (nums.contains(num[i])) {
                // Process left side
                int next = num[i] - 1;
                int count = 1;
                nums.remove(num[i]);
                while (nums.contains(next)) {
                    nums.remove(next);
                    next = next - 1;
                    count++;
                }
                // process right side
                next = num[i] + 1;
                while (nums.contains(next)) {
                    nums.remove(next);
                    next = next + 1;
                    count++;
                }
                if (count > maxLen) {
                    maxLen = count;
                }
            }
        }
        return maxLen;
    }
}
