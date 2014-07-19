package sorting;

/**
 * Created by chace on 6/7/14.
 */
public class ScrewNut {
    /*
    有两个长度为n的数组，分别存放螺钉和螺母。它们之间是一一对应的关系，
    而没有大小相同的螺钉或大小相同的螺母。现在有个机器人，它能拿起一个螺钉和一个螺母，
    试着把它们拧在一起。如果成功，返回0，如果螺钉大于螺母返回1，小于则返回-1。
    初始情况下两个数组是shuffle过的，需要设计一个算法让机器人帮你sort两个数组，
    使得两边相同index的螺钉和螺母是一对。这题虽然不是新题但我也没见过，
    虽然上来就想到肯定得用quick sort的思路，还是一时纠结住了。
    经提示才想出正确算法，是两边同时做partition。
    代码倒是很容易写，写完后又被要求分析复杂度。
     */

    public int match(int screw, int nut) {
        if (screw == nut) {
            return 0;
        } else if (screw > nut) {
            return 1;
        } else {
            return -1;
        }
    }

    public int partitionByNut(int[] s, int n, int beg, int end) {
        int i = beg;
        int t = -1;
        for (int j = beg; j <= end; j++) {
            int res = match(s[j], n);
            if (res <= 0) {
                swap(s, i, j);
                if (res == 0) {
                    t = i;
                }
                i++;
            }
        }
        swap(s, t, i - 1);
        return i - 1;
    }

    public int partitionByScrew(int[] n, int s, int beg, int end) {
        int i = beg;
        int t = -1;
        for (int j = beg; j <= end; j++) {
            int res = match(s, n[j]);
            if (res >= 0) {
                swap(n, i, j);
                if (res == 0) {
                    t = i;
                }
                i++;
            }
        }
        swap(n, t, i - 1);
        return i - 1;
    }

    public void arrange(int[] screws, int[] nuts, int beg, int end) {
        if (beg >= end) {
            return;
        }
        int p = partitionByNut(screws, nuts[beg], beg, end);
        int q = partitionByScrew(nuts, screws[p], beg, end);

        if (p != q) {
            return;
        }
        arrange(screws, nuts, beg, p - 1);
        arrange(screws, nuts, p + 1, end);
    }

    public void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
