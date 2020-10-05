package kz.algorithm;

public class QuickUnionWeighted extends QuickUnion {
    int sz[];
    QuickUnionWeighted(int N) {
        super(N);
        this.sz = new int[N];
        for(int i=0; i< N; i++){
            sz[i] =i;
        }
    }


    void union(int q, int p){
        int i = root(q);
        int j = root(p);
        if(i == j) return;
        if(this.sz[i] < this.sz [j]){
            this.id[i]=j; sz[j]+=sz[i];
        }else {
            this.id[j]=i; sz[i]+=sz[j];
        }

    }

    public static void main(String[] args) {
        QuickUnionWeighted quw = new QuickUnionWeighted(10);
        System.out.println("\n");
        quw.union(4,3);
        quw.union(7,8);
        quw.union(3,8);
        quw.union(5,9);
        quw.union(0,2);
        quw.union(9,2);
        quw.union(1,6);
        quw.union(4,9);
        quw.getElem();
        System.out.println("is 4,6 are connected " + quw.connected(4,6));
        System.out.println("is 7,6 are connected " + quw.connected(7,6));
        System.out.println("is 7,8 are connected " + quw.connected(7,8));
    }
}
