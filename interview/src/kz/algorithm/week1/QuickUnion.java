package kz.algorithm.week1;

public class QuickUnion {
    int id[];
    int N;
    QuickUnion(int N){
        this.id = new int[N];
        this.N = N;
        for(int i = 0; i< N; i++){
            id[i] = i;
        }
    }

    void getElem(){
        for(int i = 0; i<this.N; i++){
            System.out.println(i + "\t" + this.id[i]);
        }
    }
    int root(int k){
        while(this.id[k] != k){
            k = id[k];
        }
        return k;
    }

    void union(int q, int p){
        int i = root(q);
        int j = root(p);
        this.id[i] = j;
    }

    public boolean connected(int q, int p){
        return root(q) == root(p);
    }
    public static void main(String[] args) {
        QuickUnion qu = new QuickUnion(10);
        System.out.println("\n");
        qu.union(4,3);
        qu.union(7,8);
        qu.union(3,8);
        qu.union(5,9);
        qu.union(0,2);
        qu.union(9,2);
        qu.union(1,6);
        qu.union(4,9);
        qu.getElem();
        System.out.println("is 4,6 are connected " + qu.connected(4,6));
        System.out.println("is 7,6 are connected " + qu.connected(7,6));
        System.out.println("is 7,8 are connected " + qu.connected(7,8));
    }
}
