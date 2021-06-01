package kz.algorithm.data_structure.quick_find;

public class QuickFind {
    int id[];
    int N;
    QuickFind(int N){
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

    void union(int q, int p){
        int qid = id[q];
        int pid = id[p];
        for(int i = 0; i< id.length; i++){
            if(id[i] == qid){
                id[i] = pid;
            }
        }
    }

    boolean connected(int q, int p){
        return id[q] == id[p];
    }

    public static void main(String[] args) {
        QuickFind uf = new QuickFind(10);
        uf.getElem();
        System.out.println("\n");
        uf.union(4,3);
        uf.union(7,8);
        uf.union(3,8);
        uf.union(5,9);
        uf.union(0,2);
        uf.union(9,2);
        uf.union(1,6);
        uf.getElem();
        System.out.println("is 4,6 are connected " + uf.connected(4,6));
        System.out.println("is 7,6 are connected " + uf.connected(7,6));
        System.out.println("is 7,8 are connected " + uf.connected(7,8));
    }
}
