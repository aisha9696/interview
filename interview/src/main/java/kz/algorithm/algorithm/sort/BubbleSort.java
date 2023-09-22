package kz.algorithm.algorithm.sort;


/**
 * Пузырьковая сортировка
 * где большойэлемент меняя местами становиться в конечное место
 * */
public class BubbleSort extends ComparableClass {

    public static void sort(Comparable a[]){
        int N =a.length;
        while (N !=0){
            for (int i = 0 ; i < N -1; i++){
                if(less(a[i+1], a[i])){
                    exch(a, i, i+1);
                }
            }
            N--;
        }

    }

    public static void main(String[] args) {
        BubbleSort bb = new BubbleSort();
        Comparable<Integer>[] a = new Comparable[]{7, 4, 5, 1, 3, 9, 10, 2, 6, 8, 0};
        System.out.println(bb.isSorted(a));
        bb.sort(a);
        System.out.println(bb.isSorted(a));
    }

}
