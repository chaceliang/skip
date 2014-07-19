package edocteel.dp;

/**
 * Created by chace on 5/16/14.
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curSum = 0, total = 0;
        int startIndex = 0;
        for (int i = 0; i < gas.length; i++) {
            int curRemain = gas[i] - cost[i];
            if (curSum >= 0) {
                curSum += curRemain;
            } else {
                curSum = curRemain;
                startIndex = i;
            }
            total += curRemain;
        }
        return total >= 0 ? startIndex : -1;
    }
}
