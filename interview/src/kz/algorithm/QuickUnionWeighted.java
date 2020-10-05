package kz.algorithm;

public class QuickUnionWeighted extends QuickUnion {
    int sz[];
    QuickUnionWeighted(int N) {
        super(N);
        this.sz = new int[N];
    }


    void union(int q, int p){
        int i = root(q);
        int j = root(q);
        if(i == j) return;
        
    }

    public static void main(String[] args) {
        QuickUnionWeighted quw = new QuickUnionWeighted(10);

    }
}
