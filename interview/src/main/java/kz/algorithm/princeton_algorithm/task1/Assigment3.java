package kz.algorithm.princeton_algorithm.task1;

public class Assigment3 extends Assigment1{
    private boolean data[];
    private Assigment1 as;
    private int N;

    public Assigment3( int n) {
        super(n);
        this.N = N;
        data = new boolean[N];
        for (int i = 0; i < N; ++i)
            data[i] = true;
        as = new Assigment1(N);
    }
    public void remove(int x) {
        data[x] = false;
        if (x > 0 && !data[x-1])
            as.union(x, x-1);
        if (x < N - 1 && !data[x+1])
            as.union(x, x+1);
    }

    public int successor(int x) {
        if (data[x]) {
            return x;
        } else {
            int res = as.root(x) + 1;
            if (res >= N) {
                System.out.println("Error, no successor can be found");
                return -1;
            } else {
                return res;
            }
        }
    }

    public static void main(String[] args) {
        int[][] member = new int[][]{{0, 5}, {1, 7}, {2, 7}, {7, 4}, {8, 4}, {9, 6}, {2, 3}, {3, 6}, {7, 9}, {4, 5}, {0, 6}, {7, 3}};

        int cout = 0;
        int N = 10;
        Assigment3 s = new Assigment3(N);
        for (int i = 0; i < member.length; i++) {

            int q = member[i][0];
            int p = member[i][1];
            if (!s.connected(q, p)) {
                s.union(q, p);

            }

        }
        s.remove(7);
        System.out.println(s.successor(7) == 3);

    }
}
