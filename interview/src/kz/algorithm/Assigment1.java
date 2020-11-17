package kz.algorithm;

public class Assigment1 {

    private int id[];
    private int N;
    private int sz[];

    public Assigment1(int n) {
        this.id = new int[n];
        N = n;
        this.sz = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
            sz[i] = i;
        }
    }

    boolean connected(int q, int p) {
        return root(q) == root(p);
    }

    int root(int k) {
        while (this.id[k] != k) {
            id[k] = id[id[k]];
            k = id[k];
        }
        return k;
    }

    void union(int q, int p) {
        int i = root(q);
        int j = root(p);
        if (i == j) return;
        if (this.sz[i] < this.sz[j]) {
            this.id[i] = j;
            sz[j] += sz[i];
        } else {
            this.id[j] = i;
            sz[i] += sz[j];
        }

    }


    public static void main(String[] args) {
        int[][] member = new int[][]{{0, 5}, {1, 7}, {2, 7}, {7, 4}, {8, 4}, {9, 6}, {2, 3}, {3, 6}, {7, 9}, {4, 5}, {0, 6}, {7, 3}};
        int[] times = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        int cout = 0;
        int N = 10;
        Assigment1 s = new Assigment1(N);
        for (int i = 0; i < member.length; i++) {

            int q = member[i][0];
            int p = member[i][1];
            if (!s.connected(q, p)) {
                s.union(q, p);
                cout++;
            }else{
                if (cout == (N - 2)) System.out.println("Early time " + times[i]); break;
            }

        }

    }
}
