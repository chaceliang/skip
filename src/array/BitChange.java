package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chace on 6/21/14.
 */
public class BitChange {
    /*
    一个0和1组成的数组，改变其中一个数（0变1或者1变0），使得改变后数组里连续的0
    或者1的长度最大，返回这个最大长度。要求O(N)。
    比如[1 0 1]，改变0，返回3
    [1 1 0 1 0 0]，改变中间的0或者1，返回4
     */

    public static int bitChange(int[] A) {
        if (A == null) {
            throw new NullPointerException();
        }
        int len = A.length;
        List<Integer> counter = new ArrayList<Integer>();
        int prev = A[0];
        int count = 1;
        for (int i = 1; i < len; i++) {
            if (A[i] != prev) {
                counter.add(count);
                prev = A[i];
                count = 1;
            } else {
                count++;
            }
        }
        counter.add(count);
        int[] counterArray = new int[counter.size()];
        for (int i = 0; i < counter.size(); i++) {
            counterArray[i] = counter.get(i);
        }
        if (counterArray.length == 1) {
            return counterArray[0];
        } else if (counterArray.length == 2) {
            if (counterArray[0] == 1 || counterArray[1] == 1) {
                return counterArray[0] + counterArray[1];
            } else {
                return Math.max(counterArray[0], counterArray[1]);
            }
        } else {
            int maxLen = Integer.MIN_VALUE;
            for (int i = 1; i < counterArray.length - 1; i++) {
                if (counterArray[i] == 1) {
                    maxLen = Math.max(counterArray[i-1] + counterArray[i] + counterArray[i+1], maxLen);
                }
                if (i == 1 && counterArray[i-1] == 1) {
                    maxLen = Math.max(maxLen, counterArray[i-1] + counterArray[i]);
                } else if (i == counterArray.length - 2 && counterArray[counterArray.length - 1] == 1) {
                    maxLen = Math.max(maxLen, counterArray[i] + counterArray[i+1]);
                }
            }
            return maxLen;
        }
    }

    public static void main(String[] args) {
        System.out.println(bitChange(new int[]{1,0,1}));
        System.out.println(bitChange(new int[]{0,0,1}));
        System.out.println(bitChange(new int[]{1,1,1}));
        System.out.println(bitChange(new int[]{1,1,0,1,0,0}));
    }
}
