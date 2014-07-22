package array;

/**
 * Created by Chace on 7/19/14.
 */
public class UnionFind {

    int[] id;
    int[] size;

    public UnionFind(int N) {
        id = new int[N];
        size = new int[N];

        for (int i = 0; i < N; i++) {
            id[i] = i;
            size[i] = 1;
        }
    }

    public int find(int c) {
        while (c != id[c]) {
            id[c] = id[id[c]];
            c = id[c];
        }
        return c;
    }

    public void union(int p, int q) {
        int rootp = find(p);
        int rootq = find(q);

        if (rootp == rootq) return;

        if (size[rootp] < size[rootq]) {
            id[rootp] = rootq;
            size[rootq] += size[rootp];
        } else {
            id[rootq] = rootp;
            size[rootp] += size[rootq];
        }
    }
}
