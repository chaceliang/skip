package graph;

import base.Utils;

/**
 * Created by chace on 7/6/14.
 */
public class ColorCost {

    public static int min_paint(int[] rc, int[] bc, int[] gc) {
        int n = rc.length;
        int i = 1;
        int[] r = new int[n];
        int[] b = new int[n];
        int[] g = new int[n];
        r[0] = rc[0]; b[0] = bc[0]; g[0] = gc[0];
        while (i < n) {
            r[i] = rc[i] + Math.min(b[i-1], g[i-1]);
            b[i] = bc[i] + Math.min(r[i-1], g[i-1]);
            g[i] = gc[i] + Math.min(r[i-1], b[i-1]);
            i++;
        }
        return Math.min(r[n-1], Math.min(b[n-1], g[n-1]));
    }

    public static void main(String[] args) {
        System.out.println(min_paint(new int[]{1,4,6}, new int[]{2,100,2}, new int[]{3,100,4}));
    }
}
