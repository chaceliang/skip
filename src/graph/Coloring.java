package graph;

/**
 * Created by chace on 6/17/14.
 */
public class Coloring {

    int n; // Number of vertex
    int[] color; // color[k] = m vertex k color with m
    int[][] c;

    public Coloring(int n, int[][] c) {
        this.n = n;
        this.c = c;
        this.color = new int[n+1];
    }

    public boolean isOk(int k, int r) {
        for (int i = 1; i < n; i++) {
            if (color[i] != r) {
                continue;
            }
            if (c[k][i] == 1) {
                return false;
            }
        }
        return true;
    }

    public int graphColor() {
        for (int i = 1; i <= n; i++) {
            color[i] = 0;
        }
        int k = 1, m = 0, sum = 0;
        while (sum < n) {
            m++;
            for (int i = 1; i <= n; i++) {
                if (color[i] == 0) {
                    k = i;
                    color[k] = m;
                    sum++;
                    break;
                }
            }
            for (int i = k+1; i <= n; i++) {
                if (color[i] != 0) {
                    continue;
                }
                if (isOk(i, m)) {
                    continue;
                } else {
                    color[i] = m;
                    sum++;
                }
            }
        }
        return m;
    }

    public void print() {
        for (int i = 1; i <= n; i++) {
            System.out.print(color[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
//        int[][] c = new int[3][3];
//        c[0][0] = 0;
//        c[0][1] = 1;
//        c[1][0] = 1;
//        c[1][1] = 0;
//        Coloring test = new Coloring(2, c);
//        test.graphColor();
//        test.print();

        int N = 7;
        int dist[][]= {{0,1,1,1,1,1,0},//地图的邻接矩阵
            {1,0,0,0,0,1,0},
            {1,0,0,1,1,0,0},
            {1,0,1,0,1,1,0},
            {1,0,1,1,0,1,0},
            {1,1,0,1,1,0,0},
            {0,0,0,0,0,0,0}};
        int[] s = new int[N];
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i] + " ");
        }
    }
}
