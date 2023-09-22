package kz.algorithm.algorithm.sort;

public class UnorderedPQ<Key extends Comparable<Key>> extends ComparableClass {
    private Key[] pq;
    private int N; ///num elem

    public UnorderedPQ(int capacity) {
        this.pq = (Key[]) new Comparable[capacity];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    /*public void insert(Key x){
        pq[N++] = x;
    }*/

    public Key delMAx() {
        int max = 0;
        for (int i = 0; i < N; i++) {
            if (less(max, i)) max = i;
        }
        exch(pq, max, N - 1);
        return pq[--N];
    }



}
