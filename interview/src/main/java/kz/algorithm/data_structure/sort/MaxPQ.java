package kz.algorithm.data_structure.sort;

public class MaxPQ<Key extends Comparable<Key>> extends ComparableClass{
    private Key[] pq;
    private int N;


    /**
     * create an empty priority queue
     * */
    public MaxPQ(int capacity) {
        pq=(Key[]) new Comparable[capacity+1];
    }

    /**
     * create an empty priority queue with given keys
     * */
    public MaxPQ(Key a[]) {

    }

    /**
     * insert key to PQ
     * */
    /**
     * когда значения дитя меньше чем  родитель
     */
    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(pq, k, k / 2);
            k = k / 2;
        }
    }

    private void insert(Key x) {
        pq[++N] = x;
        swim(N);
    }

    /**
     * когда родительский меньше чем оба или одного дитя
     * находим большой дитя и меняем его с родителем
     */

    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j, j + 1)) j++;
            if (!less(k, j)) break;
            exch(pq, k, j);
            k = j;
        }
    }

    /**
     * Удаляем самый большой элемент
     * 1) удаляем первый элемент
     * 2) меняем первый с последним
     * 3) балансируем
     * 4) делаем null последний элемент
     * */
    public Key delMax(){
        Key max = pq[1];
        exch(pq,1,N--);
        sink(1);
        pq[N+1] = null;
        return max;
    }



    boolean isEmpty(){
        return N ==0;
    }


    public static void sort(Comparable pq[]){
        int N = pq.length;
        for(int k = N/2; k>=1; k--){
            sink(pq,k,N);
        } while (N>1){
            exch(pq,1,N);
            sink(pq, 1, --N);
        }
    }

    private static void sink(Comparable[] pq, int i, int i1) {
    }
}
