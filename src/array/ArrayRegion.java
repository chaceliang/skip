package array;

import miscellaneous.RandomSetStructure;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by chace on 6/11/14.
 */
public class ArrayRegion {
    /*
    在一个x轴上，有很多矩阵，这些矩阵下面的那条横线跟x轴是重叠的……矩阵之间
    可以部分重叠或者一个矩阵被另一个矩阵完全覆盖……要求输出最后图像的轮廓……不
    知道描述清楚了没有…这题没写代码，讲了下思路
     */

    public static int[] showRegion(Region[] regions) {
        Arrays.sort(regions);
        int len = regions.length;
        int n = regions[len-1].end;
        int[] region = new int[n+1];

        for (int i = 0; i < len; i++) {
            Region tmp = regions[i];
            for (int j = tmp.start; j <= tmp.end; j++) {
                if (region[j] < tmp.height) {
                    region[j] = tmp.height;
                }
            }
        }

        return region;
    }
    public static void main(String[] args) {
        Region[] R = new Region[10];
        Random r = new Random();
        for (int i = 0; i < R.length; i++) {
            Region t = new Region(i, r.nextInt(i+10), r.nextInt(10));
            R[i] = t;
        }

        int[] result = showRegion(R);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
        }
    }
}

class Region implements Comparable<Region> {
    int start;
    int end;
    int height;

    public Region(int s, int e, int h) {
        this.start = s;
        this.end = e;
        this.height = h;
    }

    @Override
    public int compareTo(Region region) {
        return this.end - region.end;
    }
}
