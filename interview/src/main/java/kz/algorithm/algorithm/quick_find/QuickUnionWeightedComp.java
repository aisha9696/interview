package kz.algorithm.algorithm.quick_find;

public class QuickUnionWeightedComp extends QuickUnionWeighted {
    public QuickUnionWeightedComp(int N) {
        super(N);
    }
    int root(int k){
        while(this.id[k] != k){
            id[k] = id[id[k]];
            k = id[k];
        }
        return k;
    }

    public static void main(String[] args) {
        QuickUnionWeightedComp quwc = new QuickUnionWeightedComp(10);
        quwc.union(4,3);
        quwc.union(7,8);
        quwc.union(3,8);
        quwc.union(5,9);
        quwc.union(0,2);
        quwc.union(9,2);
        quwc.union(1,6);
        quwc.union(4,9);
        quwc.getElem();
        System.out.println("is 4,6 are connected " + quwc.connected(4,6));
        System.out.println("is 7,6 are connected " + quwc.connected(7,6));
        System.out.println("is 7,8 are connected " + quwc.connected(7,8));
    }
}
